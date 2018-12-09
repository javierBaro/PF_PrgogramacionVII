package com.pf_programacionVII.model;

import java.util.ArrayList;
import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.MateriasServiceImpl;
import com.pf_programacionVII.service.UsuariosMateriasServiceImpl;


public class Tree extends Materia{


	private ArrayList<Tree> children;
	private JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
	private MateriasServiceImpl materiasService = new MateriasServiceImpl();
	private UsuariosMateriasServiceImpl usuariosMateriasService = new UsuariosMateriasServiceImpl();
	private int idPlanEstudio;
	private int idUsuario;
	
	
	public Tree () {
	}
	
	public Tree(Materia materia) {
		super(materia.getId(), materia.getNombre());
	}
	public Tree(Materia materia,int idPlanEstudio) {
		super(materia.getId(), materia.getNombre());
		this.idPlanEstudio = idPlanEstudio;
	}
	public Tree(Materia materia,int idPlanEstudio,int idUsuario) {
		super(materia.getId(), materia.getNombre());
		this.idPlanEstudio = idPlanEstudio;
		this.idUsuario=idUsuario;
	}
	public ArrayList<Tree> getChild() {
		return children;
	}
	public void setChild(ArrayList<Tree> child) {
		this.children = child;
	}

	public Tree getTree() {
		return (this);
	}
	public int getIdPlanEstudio() {
		return idPlanEstudio;
	}
	public void setIdPlanEstudio(int idPlanEstudio) {
		this.idPlanEstudio = idPlanEstudio;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	public void setChildTree() {
		ArrayList<JoinPlanEstudioMaterias> joinsGet =join.getJoinByIdPrerequsitoAndIdPlanEstudio(getId(), idPlanEstudio);

		if(!joinsGet.isEmpty() )
		{
			ArrayList<Tree> trees = new ArrayList<>();
			for (JoinPlanEstudioMaterias joinFor : joinsGet ) {
				Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
				Tree tree = new Tree(materia,idPlanEstudio,idUsuario);
			    trees.add(tree);
			}
			setChild(trees);
		}

	}
	
	public String getStringFathersAndChildTree(User actualUser) {
		int planEstudioId= actualUser.getPlanStudioId();
		
		String str2="<ul>" ;
		
      for(JoinPlanEstudioMaterias joinFor : join.getJoinByIdPrerequsitoAndIdPlanEstudio(0, planEstudioId))
      {
    		  Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
    		  Tree tree = new Tree(materia,1,actualUser.getId());
    		  str2+="<li>";
    		  str2 += tree.getStringChildTree();
    		  str2+="</li>";
      }
      str2+="</ul>";
      return str2;
	}
	
	public String getStringChildTree() {
		ArrayList<JoinPlanEstudioMaterias> joinsGet =join.getJoinByIdPrerequsitoAndIdPlanEstudio(getId(), idPlanEstudio);
		UsuariosMaterias usuariosMaterias = usuariosMateriasService.getUsuariosMateriasByIdUsuarioAndIdMateria(idUsuario, getId());
		String checked="";
		if(usuariosMaterias!=null)
		{
			if(usuariosMaterias.getRealizado()==1)
				checked="checked";
		}

		String strTree =
		"<ul>\n" + 
		  "<li>\n" + 
		    "<a href=\"#\"><input type=\"checkbox\" name="+getId()+" "+checked+">"+getNombre()+"</a>";

		if(!joinsGet.isEmpty() )
		{
			if(joinsGet.size()>1)
				strTree+=" <ul>";
			
		  ArrayList<Tree> trees = new ArrayList<>();
		    for (JoinPlanEstudioMaterias joinFor : joinsGet ) 
			{
				
				if(joinsGet.size()>1)
					strTree+="<li>";
				
				Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
				Tree tree = new Tree(materia,idPlanEstudio,idUsuario);
				strTree += tree.getStringChildTree();
			   
			    if(joinsGet.size()>1)
					strTree+="</li>";
			}
			
			if(joinsGet.size()>1)
				strTree+="</ul>";
		}
		
    strTree += 
         "</li>" + 
	 "</ul>";
		
		return strTree;
	}
	
}

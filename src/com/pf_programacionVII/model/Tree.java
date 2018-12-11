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
	private Tree tree;
	private String strTree;
	private String strMateria;
	private String strNoRealizadas;
	
	
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

	public String getStringNoRalizado() {
		System.out.println(strNoRealizadas);
		return strNoRealizadas;
	}
	
	
	public String getStringFathersAndChildTree(User actualUser,String carrera) {
		int planEstudioId= actualUser.getPlanStudioId();
		
		strNoRealizadas="";
		String str="";
      for(JoinPlanEstudioMaterias joinFor : join.getJoinByIdPrerequsitoAndIdPlanEstudio(0, planEstudioId))
      {
    		  Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
    		  Tree newTree = new Tree(materia,planEstudioId,actualUser.getId()).getStringChildTree();
    		  
			  strTree = "['"+carrera+"','"+newTree.getStrMateria()+"'],";
              str += strTree + newTree.getStrTree();
             strNoRealizadas += ","+newTree.getStrNoRealizadas();
              
      }

      return str;
	}
	
	public Tree getStringChildTree() {
		ArrayList<JoinPlanEstudioMaterias> joinsGet =join.getJoinByIdPrerequsitoAndIdPlanEstudio(getId(), idPlanEstudio);
		UsuariosMaterias usuariosMaterias = usuariosMateriasService.getUsuariosMateriasByIdUsuarioAndIdMateria(idUsuario, getId());
		 strMateria = getNombre();
		strTree="";
		if(usuariosMaterias.getRealizado()==0)
			strNoRealizadas ="'"+getNombre()+"'";
		
		if(!joinsGet.isEmpty() )
		{

			
		  ArrayList<Tree> trees = new ArrayList<>();
		    for (JoinPlanEstudioMaterias joinFor : joinsGet ) 
			{

				
				Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
				Tree newTree = new Tree(materia,idPlanEstudio,idUsuario);
				strMateria = getNombre();
				
				tree= newTree.getStringChildTree();
				strNoRealizadas ="'"+getNombre()+"',"+newTree.getStrNoRealizadas();
				strTree = "['"+getNombre()+"','"+newTree.getStrMateria()+"'],";
                strTree += tree.getStrTree(); 			
			}
			
		}
		
		return this;
	}

	public String getStrTree() {
		return strTree;
	}

	public void setStrTree(String strTree) {
		this.strTree = strTree;
	}

	public String getStrMateria() {
		return strMateria;
	}

	public void setStrMateria(String strMateria) {
		this.strMateria = strMateria;
	}

	public String getStrNoRealizadas() {
		return strNoRealizadas;
	}

	public void setStrNoRealizadas(String strNoRealizadas) {
		this.strNoRealizadas = strNoRealizadas;
	}
	
}

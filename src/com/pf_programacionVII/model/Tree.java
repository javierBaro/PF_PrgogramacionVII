package com.pf_programacionVII.model;

import java.util.ArrayList;

import com.pf_programacionVII.service.CarreraServiceImpl;
import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.MateriasServiceImpl;
import com.pf_programacionVII.service.UsuariosMateriasServiceImpl;



public class Tree extends Materia{


	//private ArrayList<Tree> children;
	private JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
	private JoinPlanEstudioMateriasServiceImpl join2 = new JoinPlanEstudioMateriasServiceImpl();
	private MateriasServiceImpl materiasService = new MateriasServiceImpl();
	private UsuariosMateriasServiceImpl usuariosMateriasService = new UsuariosMateriasServiceImpl();
	private CarreraServiceImpl carreraService= new CarreraServiceImpl();
	private int idPlanEstudio;
	private int idUsuario;
	private Tree tree;
	private String strTree;
	private String strMateria;
	private String strNoRealizadas;
	private ArrayList<MateriaRealizada> materiaRealizadas = new ArrayList<>();
	private User actualUser = new User();
	private int countRealizadas;
	private int countNoRealizadas;
	
	
	public Tree () {
	}
	public Tree (User actualUser) {
		this.actualUser=actualUser;
	}
	
	public Tree(Materia materia) {
		super(materia.getId(), materia.getNombre());
	}
	public Tree(Materia materia,int idPlanEstudio) {
		super(materia.getId(), materia.getNombre());
		this.idPlanEstudio = idPlanEstudio;
	}
	public Tree(Materia materia,int idPlanEstudio,User actualUser) {
		super(materia.getId(), materia.getNombre());
		this.idPlanEstudio = idPlanEstudio;
this.actualUser=actualUser;
		
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
	
	public ArrayList<MateriaRealizada> getMateriaRealizadas() {
		return materiaRealizadas;
	}

	public void setMateriaRealizadas(ArrayList<MateriaRealizada> materiaRealizadas) {
		this.materiaRealizadas = materiaRealizadas;
	}
	public String getStringFathersAndChildTree() {
		final long startTime = System.nanoTime()/1000000000;
		int planEstudioId= actualUser.getPlanStudioId();
		String carrera = carreraService.getCarreraByidPlanEstudio(actualUser.getPlanStudioId()).getNombre();
		strTree="";
		strNoRealizadas="";
		String str="",sinRequisito="";
      for(JoinPlanEstudioMaterias joinFor : join.getJoinByIdPrerequsitoAndIdPlanEstudio(0, planEstudioId))
      {      	
    		  Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
    		  Tree newTree = new Tree(materia,planEstudioId,actualUser).getStringChildTree();
    		 int size= join2.getJoinByIdPrerequsitoAndIdPlanEstudio(joinFor.getMateriaId(), planEstudioId).size();
			  
    		 if(size!=0)
    		  strTree = "['"+carrera+"','"+newTree.getStrMateria()+"'],";
			 else
				  sinRequisito+="'"+materia.getNombre()+"',";
    		  
              str += strTree + newTree.getStrTree();
             
              materiaRealizadas.addAll(newTree.getMateriaRealizadas());
              countNoRealizadas+=newTree.countNoRealizadas;
              countRealizadas+=newTree.countRealizadas;   
              strNoRealizadas += ","+newTree.getStrNoRealizadas();
             
             
      }
             sinRequisito= "['"+carrera+"','SIN REQUISITOS',"+sinRequisito+"],";
     		final long endTime = System.nanoTime()/1000000000;
    	  	System.out.println("doGetUserServlet(Login)--Start--: "+startTime+ " --End--: "+endTime+"--Elapse Time--: "+(endTime-startTime)); 

      return str+sinRequisito;
	}
	
	public Tree getStringChildTree() {
		ArrayList<JoinPlanEstudioMaterias> joinsGet =join.getJoinByIdPrerequsitoAndIdPlanEstudio(getId(), idPlanEstudio);
		UsuariosMaterias usuariosMaterias = usuariosMateriasService.getUsuariosMateriasByIdUsuarioAndIdMateria(actualUser.getId(), getId());

		strNoRealizadas ="";
		strMateria = getNombre();
		strTree="";

		if(usuariosMaterias.getRealizado()==0)
		{
			countNoRealizadas++;
		    materiaRealizadas.add(new MateriaRealizada(getId(),getNombre().replaceAll("\\\\n",""),false));
			strNoRealizadas ="'"+getNombre()+"'";
		}
		else
		{
			countRealizadas++;
			materiaRealizadas.add(new MateriaRealizada(getId(),getNombre().replaceAll("\\\\n",""),true));
			
		}
			


		if(!joinsGet.isEmpty() )
		{

		    for (JoinPlanEstudioMaterias joinFor : joinsGet ) 
			{
		    	
				Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
				Tree newTree = new Tree(materia,idPlanEstudio,actualUser);
				strMateria = getNombre();
				tree= newTree.getStringChildTree();	
				strTree += "['"+getNombre()+"','"+newTree.getStrMateria()+"'],";
                strTree += tree.getStrTree(); 
                materiaRealizadas.addAll(newTree.getMateriaRealizadas());                
                countNoRealizadas+=newTree.countNoRealizadas;
                countRealizadas+=newTree.countRealizadas;                          
                strNoRealizadas +=","+newTree.getStrNoRealizadas();
           
			}	
 		}
		return this;
	}
	public int getCountRealizadas() {
		return countRealizadas;
	}
	public void setCountRealizadas(int countRealizadas) {
		this.countRealizadas = countRealizadas;
	}
	public int getCountNoRealizadas() {
		return countNoRealizadas;
	}
	public void setCountNoRealizadas(int countNoRealizadas) {
		this.countNoRealizadas = countNoRealizadas;
	}
	
}
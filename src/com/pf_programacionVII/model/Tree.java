package com.pf_programacionVII.model;

import java.util.ArrayList;

import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.MateriasServiceImpl;


public class Tree extends Materia{
	
	private ArrayList<Tree> children;
	private JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
	private MateriasServiceImpl materiasService = new MateriasServiceImpl();
	private int idPlanEstudio;
	
	
	public Tree () {
	}
	
	public Tree(Materia materia) {
		super(materia.getId(), materia.getNombre());
	}
	public Tree(Materia materia,int idPlanEstudio) {
		super(materia.getId(), materia.getNombre());
		this.idPlanEstudio = idPlanEstudio;
	}
	public ArrayList<Tree> getChild() {
		return children;
	}
	public void setChild(ArrayList<Tree> child) {
		this.children = child;
	}
	
	public String toStringTree() {
		ArrayList<JoinPlanEstudioMaterias> joinsGet =join.getJoinByIdPrerequsitoAndIdPlanEstudio(getId(), idPlanEstudio);
		String strTree ="<ul>\n" + 
				   "<li>\n" + 
				      "<a href=\"#\"><input type=\"checkbox\" name="+getId()+">"+getNombre()+"</a>"
				;

		if(!joinsGet.isEmpty() )
		{
			if(joinsGet.size()>1)
				strTree+=" <ul>";
			
			ArrayList<Tree> trees = new ArrayList<>();
			for (JoinPlanEstudioMaterias joinFor : joinsGet ) {
				if(joinsGet.size()>1)
					strTree+="<li>";
				
				Materia materia = materiasService.getMateriaByidMateria(joinFor.getMateriaId());
				Tree tree = new Tree(materia);
				tree.setIdPlanEstudio(idPlanEstudio);
				strTree += tree.toStringTree();
			    trees.add(tree);
			    if(joinsGet.size()>1)
					strTree+="</li>";
			}
			setChild(trees);
			if(joinsGet.size()>1)
				strTree+="</ul>";
		}
			strTree += "</li>" + 
					"</ul>";
		
		
		return strTree;
	}
	public int getIdPlanEstudio() {
		return idPlanEstudio;
	}
	public void setIdPlanEstudio(int idPlanEstudio) {
		this.idPlanEstudio = idPlanEstudio;
	}
	public Tree getTree() {
		return (this);
	}

	
	
}

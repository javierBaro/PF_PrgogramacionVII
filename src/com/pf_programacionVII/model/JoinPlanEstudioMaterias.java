package com.pf_programacionVII.model;

public class JoinPlanEstudioMaterias {

	private int id;
	private int planEstudioId;
	private int materiaId;
	private int prerequisitoMateriaId;
	private int cuatrimestre;
	
	public JoinPlanEstudioMaterias(int planEstudioId, int materiaId, int prerequisitoMateriaId, int cuatrimestre) {
		this.planEstudioId = planEstudioId;
		this.materiaId = materiaId;
		this.prerequisitoMateriaId = prerequisitoMateriaId;
		this.cuatrimestre = cuatrimestre;
	}
	
	public JoinPlanEstudioMaterias() {
	}

	public int getPlanEstudioId() {
		return planEstudioId;
	}
	public void setPlanEstudioId(int planEstudioId) {
		this.planEstudioId = planEstudioId;
	}
	public int getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}
	public int getPrerequisitoMateriaId() {
		return prerequisitoMateriaId;
	}
	public void setPrerequisitoMateriaId(int prerequisitoMateriaId) {
		this.prerequisitoMateriaId = prerequisitoMateriaId;
	}
	public int getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

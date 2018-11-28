package com.pf_programacionVII.model;


public class UsuariosMaterias {

private int id;
private int UsuarioId;
private int PlanEstudioMateriasId;
private int realizado;

public UsuariosMaterias() {
}
public UsuariosMaterias(int usuarioId, int planEstudioMateriasId, int realizado) {
	UsuarioId = usuarioId;
	PlanEstudioMateriasId = planEstudioMateriasId;
	this.realizado = realizado;
}

public UsuariosMaterias(int id, int usuarioId, int planEstudioMateriasId, int realizado) {
	this.id = id;
	UsuarioId = usuarioId;
	PlanEstudioMateriasId = planEstudioMateriasId;
	this.realizado = realizado;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUsuarioId() {
	return UsuarioId;
}
public void setUsuarioId(int usuarioId) {
	UsuarioId = usuarioId;
}
public int getPlanEstudioMateriasId() {
	return PlanEstudioMateriasId;
}
public void setPlanEstudioMateriasId(int planEstudioMateriasId) {
	PlanEstudioMateriasId = planEstudioMateriasId;
}
public int getRealizado() {
	return realizado;
}
public void setRealizado(int realizado) {
	this.realizado = realizado;
}

}

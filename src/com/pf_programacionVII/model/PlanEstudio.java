package com.pf_programacionVII.model;

import java.sql.Date;

public class PlanEstudio {
 private int id;
 private int carreraId;
 private int facultadId;
 private Date fechaPlanEstudio;
 
public PlanEstudio() {
	
}
 
public PlanEstudio(int id, int carreraId, int facultadId, Date fechaPlanEstudio) {
	this.id = id;
	this.carreraId = carreraId;
	this.facultadId = facultadId;
	this.fechaPlanEstudio = fechaPlanEstudio;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCarreraId() {
	return carreraId;
}
public void setCarreraId(int carreraId) {
	this.carreraId = carreraId;
}
public int getFacultadId() {
	return facultadId;
}
public void setFacultadId(int facultadId) {
	this.facultadId = facultadId;
}
public Date getFechaPlanEstudio() {
	return fechaPlanEstudio;
}
public void setFechaPlanEstudio(Date fechaPlanEstudio) {
	this.fechaPlanEstudio = fechaPlanEstudio;
}
}

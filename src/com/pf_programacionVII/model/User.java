package com.pf_programacionVII.model;

public class User {
	private int id;
	private String nombre;
	private String usuario;
	private String contrasena;
	private int planStudioId;
	private int rolesId;

	public User() {
	}

	public User(String nombre, String usuario, String contrasena, int planStudioId, int rolesId) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.planStudioId = planStudioId;
		this.rolesId = rolesId;
	}
	public User(int id,String nombre, String usuario, String contrasena, int planStudioId, int rolesId) {
		this.id=id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.planStudioId = planStudioId;
		this.rolesId = rolesId;
	}

	public int getRolesId() {
		return rolesId;
	}

	public void setRolesId(int rolesId) {
		this.rolesId = rolesId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getPlanStudioId() {
		return planStudioId;
	}

	public void setPlanStudioId(int planStudioId) {
		this.planStudioId = planStudioId;
	}

}

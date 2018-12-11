package com.pf_programacionVII.model;

public class MateriaRealizada extends Materia{
	
    private Boolean realizada;

    public MateriaRealizada()
    {
    }
	public MateriaRealizada(int id, String nombre, Boolean realizada) {
		super(id, nombre);
		this.realizada = realizada;
	}

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}
    

}

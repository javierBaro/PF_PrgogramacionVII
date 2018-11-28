package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.Facultad;


public interface FacultadService {

	public ArrayList<Facultad> getAllFacultad() ;
	public Facultad getFacultadByidFacultad(int idFacultad);
	public void insertFacultad(String facultad);
	public void updateFacultad(Facultad facultad);
    public void deleteFacultad(int idFacultad);
}

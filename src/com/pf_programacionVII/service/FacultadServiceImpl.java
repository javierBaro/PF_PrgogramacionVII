package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.Facultad;
import com.pf_programacionVII.repository.FacultadRepository;

public class FacultadServiceImpl implements FacultadService{

	FacultadRepository facultadRepository = new FacultadRepository();
	
	@Override
	public ArrayList<Facultad> getAllFacultad() {
		return facultadRepository.getAll("Call GetFacultades()");
	}

	@Override
	public Facultad getFacultadByidFacultad(int idFacultad) {
		return facultadRepository.getFacultadById("Call GetFacultadById(?)", idFacultad);
	}

	@Override
	public void insertFacultad(String facultad) {
		facultadRepository.insertFacultad("Call SetFacultad(?)", facultad);
	}

	@Override
	public void updateFacultad(Facultad facultad) {
		facultadRepository.updateFacultad("Call UpdateFacultad(?)", "Call GetFacultadById(?)", facultad);
	}

	@Override
	public void deleteFacultad(int idFacultad) {
		facultadRepository.deleteFacultad("Call DeleteFacultad(?)", idFacultad);
	}

}

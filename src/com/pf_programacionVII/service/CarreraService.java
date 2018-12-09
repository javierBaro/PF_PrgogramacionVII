package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;

public interface CarreraService {
 
	public ArrayList<Carrera> getAllCarrera();
	public Carrera getCarreraByidCarrera(int idCarrera);
	public Carrera getCarreraByidPlanEstudio(int idPlanEstudio);
	public void insertCarrera(String carrera);
	public void updateCarrera(Carrera carrera);
    public void deleteCarrera(int idCarrera);
}

package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.repository.CarreraRepository;

public class CarreraServiceImpl implements CarreraService {

	CarreraRepository carreraRepository = new CarreraRepository();
	
	@Override
	public ArrayList<Carrera> getAllCarrera() {
		return carreraRepository.getAll("Call GetCarreras()");
	}

	@Override
	public Carrera getCarreraByidCarrera(int idCarrera) {
		return carreraRepository.getCarreraById("Call GetCarreraById(?)", idCarrera);
	}

	@Override
	public void insertCarrera(String carrera) {
		this.carreraRepository.insertCarrera("Call SetCarrera(?)", carrera);
		
	}

	@Override
	public void updateCarrera(Carrera carrera) {
		this.carreraRepository.updateCarrera("Call SetCarrera(?)","Call GetCarreraById(?)", carrera);
		
	}

	@Override
	public void deleteCarrera(int idCarrera) {
		this.carreraRepository.deleteCarrera("Call DeleteCarrera(?)", idCarrera);
	}

}

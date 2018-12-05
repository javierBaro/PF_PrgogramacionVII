package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.repository.MateriaRepository;

public class MateriasServiceImpl implements MateriaService{

	MateriaRepository materiaRepository = new MateriaRepository();
	
	@Override
	public ArrayList<Materia> getAllMateria() {
		return materiaRepository.getAll("Call GetMaterias()");
	}

	@Override
	public Materia getMateriaByidMateria(int idMateria) {
		return materiaRepository.getMateriaById("Call GetMateriaById(?)", idMateria);
	}

	@Override
	public void insertMateria(String materia) {
		this.materiaRepository.insertMateria("Call SetMateria(?)", materia);
		
	}

	@Override
	public void updateMateria(Materia materia) {
		this.materiaRepository.updateMateria("Call SetMateria(?)","Call GetMateriaById(?)", materia);
		
	}

	@Override
	public void deleteMateria(int idMateria) {
		this.materiaRepository.deleteMateria("Call DeleteMateria(?)", idMateria);
		
	}

	

}

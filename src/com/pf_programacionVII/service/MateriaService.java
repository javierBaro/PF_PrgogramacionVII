package com.pf_programacionVII.service;

import java.util.ArrayList;
import com.pf_programacionVII.model.Materia;

public interface MateriaService {
	public ArrayList<Materia> getAllMateria() ;
	public Materia getMateriaByidMateria(int idMateria);
	public void insertMateria(String materia);
	public void updateMateria(Materia materia);
    public void deleteMateria(int idMateria);
}

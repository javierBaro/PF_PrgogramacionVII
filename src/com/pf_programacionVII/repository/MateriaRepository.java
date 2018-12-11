package com.pf_programacionVII.repository;


import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.User;

public class MateriaRepository extends Repository<Materia> {

	@Override
	protected Materia getObject() {
		try {
			Materia materia =new Materia();
			materia.setId(rs.getInt("materias_id"));
			materia.setNombre(rs.getString("nombre"));
			return materia;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Materia> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	public Materia getMateriaById(String procedure,int materiaId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)materiaId);
	setParameters(parameters);
	return getOne();
	}
	
	public ArrayList<Materia> getMateriaByIdPlanEstudio(String procedure,int planEstudioId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)planEstudioId);
	setParameters(parameters);
	return getMany();
	}
	
	public void insertMateria(String procedure,String nombreMateria) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters=new ArrayList<>();
		parameters.add(nombreMateria);
		setParameters(parameters);
		save();
	}
	
	//siempre tiene el objeto materia traer su id
	public void updateMateria(String procedureUpdateMateria, String procedureGetMateria, Materia materia) {
		ArrayList<Object> parameters = new ArrayList<>();
		Materia materiaServer = getMateriaById(procedureGetMateria, materia.getId());
		setStoreProcedure(procedureUpdateMateria);
		if (materiaServer != null) {
			
			if (materia.getNombre() != null)
				parameters.add(materia.getNombre());
			else
				parameters.add(materiaServer.getNombre());			
		
			parameters.add(materia.getId());

			setParameters(parameters);
			save();
		}
		
		
	}
	public void deleteMateria(String procedure,int materiaId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(materiaId);
		setParameters(parameters);
		delete();
	}
	


	
	
	
	
	
}

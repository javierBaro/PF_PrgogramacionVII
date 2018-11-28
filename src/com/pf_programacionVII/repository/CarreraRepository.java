package com.pf_programacionVII.repository;


import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.User;

public class CarreraRepository extends Repository<Carrera> {

	@Override
	protected Carrera getObject() {
		try {
			Carrera carrera =new Carrera();
			carrera.setId(rs.getInt("carreras_id"));
			carrera.setNombre(rs.getString("nombre"));
			return carrera;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Carrera> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	public Carrera getCarreraById(String procedure,int carreraId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)carreraId);
	setParameters(parameters);
	return getOne();
	}
	public void insertCarrera(String procedure,String nombreCarrera) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters=new ArrayList<>();
		parameters.add(nombreCarrera);
		setParameters(parameters);
		save();
	}
	
	//siempre el objeto carrera tiene que traer su id
	public void updatetCarrera(String procedureUpdateMateria, String procedureGetCarrera, Carrera carrera) {
		ArrayList<Object> parameters = new ArrayList<>();
		Carrera carreraServer = getCarreraById(procedureGetCarrera, carrera.getId());
		setStoreProcedure(procedureUpdateMateria);
		if (carreraServer != null) {
			
			if (carrera.getNombre() != null)
				parameters.add(carrera.getNombre());
			else
				parameters.add(carreraServer.getNombre());			
		
			parameters.add(carrera.getId());

			setParameters(parameters);
			save();
		}
	}
	
	public void deleteCarrera(String procedure,int carreraId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(carreraId);
		setParameters(parameters);
		delete();
	}

	
	
	
	
	
}

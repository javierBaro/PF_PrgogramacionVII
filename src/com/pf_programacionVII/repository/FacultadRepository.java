package com.pf_programacionVII.repository;


import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.Facultad;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.User;

public class FacultadRepository extends Repository<Facultad> {

	@Override
	protected Facultad getObject() {
		try {
			Facultad facultad =new Facultad();
			facultad.setId(rs.getInt("facultades_id"));
			facultad.setNombre(rs.getString("nombre"));
			return facultad;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Facultad> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	public Facultad getFacultadById(String procedure,int facultadId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)facultadId);
	setParameters(parameters);
	return getOne();
	}
	public void insertFacultad(String procedure,String nombreFacultad) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters=new ArrayList<>();
		parameters.add(nombreFacultad);
		setParameters(parameters);
		save();
	}
	
	//siempre el objeto carrera tiene que traer su id
	public void updateFacultad(String procedureUpdateFacultad, String procedureGetFacultad, Facultad facultad) {
		ArrayList<Object> parameters = new ArrayList<>();
		Facultad facultadServer = getFacultadById(procedureGetFacultad, facultad.getId());
		setStoreProcedure(procedureUpdateFacultad);
		if (facultadServer != null) {
			
			if (facultad.getNombre() != null)
				parameters.add(facultad.getNombre());
			else
				parameters.add(facultadServer.getNombre());			
		
			parameters.add(facultad.getId());

			setParameters(parameters);
			save();
		}
	}
	

	public void deleteFacultad(String procedure,int facultadId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(facultadId);
		setParameters(parameters);
		delete();
	}
	
	
	
	
	
}

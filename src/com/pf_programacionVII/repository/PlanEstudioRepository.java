package com.pf_programacionVII.repository;


import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.PlanEstudio;
import com.pf_programacionVII.model.User;

public class PlanEstudioRepository extends Repository<PlanEstudio> {

	@Override
	protected PlanEstudio getObject() {
		try {
			PlanEstudio PlanEstudio =new PlanEstudio();
			PlanEstudio.setId(rs.getInt("plan_estudio_id"));
			PlanEstudio.setCarreraId(rs.getInt("carrera_id"));
			PlanEstudio.setFacultadId(rs.getInt("facultad_id"));
			PlanEstudio.setFechaPlanEstudio(rs.getDate("fecha_plan_estudio"));
			
			return PlanEstudio;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PlanEstudio> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	
	public PlanEstudio getPlanEstudioById(String procedure,int planEstudioId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)planEstudioId);
	setParameters(parameters);
	return getOne();
	}
	public PlanEstudio getPlanEstudioByIdUsuario(String procedure,int usuarioId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)usuarioId);
	setParameters(parameters);
	return getOne();
	}
	
	public void insertPlanEstudio(String procedure, PlanEstudio planEstudio) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters=new ArrayList<>();
		parameters.add(planEstudio.getCarreraId());
		parameters.add(planEstudio.getFacultadId());
		parameters.add(planEstudio.getFechaPlanEstudio());
		setParameters(parameters);
		save();
	}
	
	//siempre el objeto carrera tiene que traer su id
	public void updatePlanEstudio(String procedureUpdatePlanEstudio, String procedureGetPlanEstudio, PlanEstudio planEstudio) {
		ArrayList<Object> parameters = new ArrayList<>();
		PlanEstudio planEstudioServer = getPlanEstudioById(procedureGetPlanEstudio, planEstudio.getId());
		setStoreProcedure(procedureUpdatePlanEstudio);
		if (planEstudioServer != null) {
			
			if (planEstudio.getCarreraId() != 0)
				parameters.add(planEstudio.getCarreraId());
			else 
				parameters.add(planEstudioServer.getCarreraId());	
			
			if (planEstudio.getFacultadId() != 0)
				parameters.add(planEstudio.getFacultadId());
			else 
				parameters.add(planEstudioServer.getFacultadId());	
			
			if (planEstudio.getFechaPlanEstudio() != null)
				parameters.add(planEstudio.getFechaPlanEstudio());
			else 
				parameters.add(planEstudioServer.getFechaPlanEstudio());
			
			parameters.add(planEstudio.getId());

			setParameters(parameters);
			save();
		}
	}
	

	public void deletePlanEstudio(String procedure,int planEstudioId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(planEstudioId);
		setParameters(parameters);
		delete();
	}
	
	
	
	
	
}

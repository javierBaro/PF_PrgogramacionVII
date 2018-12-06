package com.pf_programacionVII.repository;


import java.sql.SQLException;
import java.util.ArrayList;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.User;

public class JoinPlanEstudioMateriasRepository extends Repository<JoinPlanEstudioMaterias> {

	@Override
	protected JoinPlanEstudioMaterias getObject() {
		try {
			JoinPlanEstudioMaterias joinPlanEstudioMaterias =new JoinPlanEstudioMaterias();
			joinPlanEstudioMaterias.setId(rs.getInt("plan_estudio_materias_id"));
			joinPlanEstudioMaterias.setPlanEstudioId(rs.getInt("plan_estudio_id"));
			joinPlanEstudioMaterias.setMateriaId(rs.getInt("materia_id"));
			joinPlanEstudioMaterias.setPrerequisitoMateriaId(rs.getInt("prerequisito_materia_id"));
			joinPlanEstudioMaterias.setCuatrimestre(rs.getInt("cuatrimestre"));
			
			return joinPlanEstudioMaterias;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<JoinPlanEstudioMaterias> getAll(String procedure) {
		setStoreProcedure(procedure);
		return getMany();
	}
	
	public JoinPlanEstudioMaterias getJoinById(String procedure,int joinId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)joinId);
	setParameters(parameters);
	return getOne();
	}
	public ArrayList<JoinPlanEstudioMaterias> getJoinByIdPrerequisitoAndIdPlanEstudio(String procedure,int prerequisitoId,int planEstudioId )
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)prerequisitoId);
	parameters.add((Integer)planEstudioId);
	setParameters(parameters);
	return getMany();
	}
	public ArrayList<JoinPlanEstudioMaterias >getJoinByIdPlanEstudio(String procedure,int PlanEstudioId)
	{
	setStoreProcedure(procedure);
	ArrayList<Object> parameters=new ArrayList<>();
	parameters.add((Integer)PlanEstudioId);
	setParameters(parameters);
	return getMany();
	}
	
	public void insertJoin(String procedure, JoinPlanEstudioMaterias join) {
		setStoreProcedure(procedure);
		ArrayList<Object> parameters=new ArrayList<>();
		parameters.add(join.getPlanEstudioId());
		parameters.add(join.getMateriaId());
		parameters.add(join.getPrerequisitoMateriaId());
		parameters.add(join.getCuatrimestre());
		setParameters(parameters);
		save();
	}
	
	//siempre el objeto carrera tiene que traer su id
	public void updateJoin(String procedureUpdateJoin, String procedureGetJoin, JoinPlanEstudioMaterias join) {
		ArrayList<Object> parameters = new ArrayList<>();
		JoinPlanEstudioMaterias joinServer = getJoinById(procedureGetJoin, join.getId());
		setStoreProcedure(procedureUpdateJoin);
		if (joinServer != null) {
			
			if (join.getPlanEstudioId() != 0)
				parameters.add(join.getPlanEstudioId());
			else 
				parameters.add(joinServer.getPlanEstudioId());	
			
			if (join.getMateriaId() != 0)
				parameters.add(join.getMateriaId());
			else 
				parameters.add(joinServer.getMateriaId());	
			
			if (join.getPrerequisitoMateriaId() != 0)
				parameters.add(join.getPrerequisitoMateriaId());
			else 
				parameters.add(joinServer.getPrerequisitoMateriaId());
			
			if (join.getCuatrimestre() != 0)
				parameters.add(join.getCuatrimestre());
			else 
				parameters.add(joinServer.getCuatrimestre());	
		
			parameters.add(join.getId());

			setParameters(parameters);
			save();
		}
	}
	

	public void deleteJoin(String procedure,int joinId)
	{
		setStoreProcedure(procedure);
		ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(joinId);
		setParameters(parameters);
		delete();
	}
	
	
	
	
	
}

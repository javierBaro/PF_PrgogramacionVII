package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.repository.JoinPlanEstudioMateriasRepository;

public class JoinPlanEstudioMateriasServiceImpl implements JoinPlanEstudioMateriasService {

	JoinPlanEstudioMateriasRepository join = new JoinPlanEstudioMateriasRepository();
	
	
	@Override
	public ArrayList<JoinPlanEstudioMaterias> getAllJoin() {
		return join.getAll("Call GetPlanEstudioMaterias()");
	}

	@Override
	public JoinPlanEstudioMaterias getJoinById(int idJoin) {
		return null;
	}

	@Override
	public JoinPlanEstudioMaterias getJoinByidPlanEstudioMaterias(int idPlanEstudio) {
		return join.getJoinById("Call GetPlanEstudioMateriasByidPlanEstudioMaterias(?)", idPlanEstudio);
	}

	@Override
	public void insertJoin(JoinPlanEstudioMaterias join) {
	this.join.insertJoin("Call SetPlanEstudioMaterias(?,?,?,?)", join);
		
	}

	@Override
	public void updateJoin(JoinPlanEstudioMaterias join) {
		this.join.updateJoin("Call UpdatePlanEstudioMaterias(?,?,?,?)","Call GetPlanEstudioMateriasByidPlanEstudioMaterias(?)", join);
	}

	@Override
	public void deletePlanJoin(int idJoin) {
		this.join.deleteJoin("deletePlanEstudioMaterias(?)", idJoin);
		
	}

}

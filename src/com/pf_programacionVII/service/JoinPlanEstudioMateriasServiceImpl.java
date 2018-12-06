package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.repository.JoinPlanEstudioMateriasRepository;
import com.pf_programacionVII.repository.UserRepository;

public class JoinPlanEstudioMateriasServiceImpl implements JoinPlanEstudioMateriasService {

	JoinPlanEstudioMateriasRepository join = new JoinPlanEstudioMateriasRepository();

	@Override
	public ArrayList<JoinPlanEstudioMaterias> getAllJoin() {
		return join.getAll("Call GetPlanEstudioMaterias()");
	}
	@Override
	public ArrayList<JoinPlanEstudioMaterias> getJoinByIdPrerequsitoAndIdPlanEstudio(int idPrerequisito, int idPlanEstudio) {		
		return join.getJoinByIdPrerequisitoAndIdPlanEstudio("Call GetPlanEstudioMateriasByIdPrerequisitoAndIdPlanEstudio(?,?)", idPrerequisito, idPlanEstudio);
	}

	@Override
	public JoinPlanEstudioMaterias getJoinById(int idJoin) {
		return join.getJoinById("Call GetPlanEstudioMateriasById(?)", idJoin);
	}

	@Override
	public ArrayList<JoinPlanEstudioMaterias> getJoinByidPlanEstudio(int idPlanEstudio) {
		return join.getJoinByIdPlanEstudio("Call GetPlanEstudioMateriasByidPlanEstudio(?)", idPlanEstudio);
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

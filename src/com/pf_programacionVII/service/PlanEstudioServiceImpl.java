package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.PlanEstudio;
import com.pf_programacionVII.repository.PlanEstudioRepository;

public class PlanEstudioServiceImpl implements PlanEstudioService{
	
	PlanEstudioRepository planEstudioRepository = new PlanEstudioRepository();

	@Override
	public ArrayList<PlanEstudio> getAllPlanesEstudios() {
		return planEstudioRepository.getAll("GetPlanesEstudios()");
	}

	@Override
	public PlanEstudio getPlanEstudioByidUsuario(int idUsuario) {
		return planEstudioRepository.getPlanEstudioById("Call GetPlanEstudioByIdUsuario(?)", idUsuario);
	}

	@Override
	public PlanEstudio getPlanEstudioByidPlanEstudio(int idPlanEstudio) {
		return planEstudioRepository.getPlanEstudioByIdUsuario("Call GetPlanEstudioById(?)", idPlanEstudio);
	}

	@Override
	public void insertPlanEstudio(PlanEstudio planEstudio) {
		planEstudioRepository.insertPlanEstudio("Call SetPlanEstudio(?,?,?)", planEstudio);
		
	}

	@Override
	public void updatePlanEstudio(PlanEstudio planEstudio) {
		planEstudioRepository.updatePlanEstudio("Call UpdatePlanEstudio(?,?,?,?)", "Call GetPlanEstudioById(?)", planEstudio);
	}

	@Override
	public void deletePlanEstudio(int idPlanEstudio) {
		planEstudioRepository.deletePlanEstudio("Call DeletePlanEstudio(?)", idPlanEstudio);
	}

	@Override
	public ArrayList<PlanEstudio> getPlanEstudioByidCarrera(int idCarrera) {
		return planEstudioRepository.getPlanEstudioByIdCarrera("Call GetPlanEstudioByIdCarrera(?)", idCarrera);
	}



}

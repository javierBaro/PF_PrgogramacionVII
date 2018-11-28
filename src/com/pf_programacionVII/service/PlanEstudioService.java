package com.pf_programacionVII.service;


import java.util.ArrayList;

import com.pf_programacionVII.model.PlanEstudio;


public interface PlanEstudioService {
	
	public ArrayList<PlanEstudio> getAllPlanesEstudios() ;
	public PlanEstudio getPlanEstudioByidPlanEstudio(int idPlanEstudio);
	public PlanEstudio getPlanEstudioByidUsuario(int idUsuario);
	public void insertPlanEstudio(PlanEstudio planEstudio);
	public void updatePlanEstudio(PlanEstudio planEstudio);
    public void deletePlanEstudio(int idPlanEstudio);
}

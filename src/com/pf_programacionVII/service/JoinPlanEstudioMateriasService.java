package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.PlanEstudio;

public interface JoinPlanEstudioMateriasService {
	public ArrayList<JoinPlanEstudioMaterias> getAllJoin() ;
	public JoinPlanEstudioMaterias getJoinById(int idJoin);
	public ArrayList<JoinPlanEstudioMaterias> getJoinByIdPrerequsitoAndIdPlanEstudio(int idPrerequisito,int idPlanEstudio);
	public ArrayList<JoinPlanEstudioMaterias> getJoinByidPlanEstudio(int idPlanEstudio);
	public JoinPlanEstudioMaterias getJoinByIdMateriaAndIdPlanEstudio(int idMateria,int idPlanEstudio);
	public void insertJoin(JoinPlanEstudioMaterias join);
	public void updateJoin(JoinPlanEstudioMaterias join);
    public void deletePlanJoin(int idJoin);
}

package com.pf_programacionVII.service;

import java.util.ArrayList;

import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.PlanEstudio;

public interface JoinPlanEstudioMateriasService {
	public ArrayList<JoinPlanEstudioMaterias> getAllJoin() ;
	public JoinPlanEstudioMaterias getJoinById(int idJoin);
	public JoinPlanEstudioMaterias getJoinByidPlanEstudioMaterias(int idPlanEstudio);
	public void insertJoin(JoinPlanEstudioMaterias join);
	public void updateJoin(JoinPlanEstudioMaterias join);
    public void deletePlanJoin(int idJoin);
}

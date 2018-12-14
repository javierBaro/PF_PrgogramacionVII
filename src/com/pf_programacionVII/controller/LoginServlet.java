package com.pf_programacionVII.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.PlanEstudio;
import com.pf_programacionVII.model.User;
import com.pf_programacionVII.service.CarreraServiceImpl;
import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.PlanEstudioServiceImpl;
import com.pf_programacionVII.service.UserServiceImpl;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PlanEstudioServiceImpl planEstudioService = new PlanEstudioServiceImpl();
       CarreraServiceImpl carreraService= new CarreraServiceImpl();     
		JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
		CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();
		String userinfo;
		HttpSession session;

	public LoginServlet() {
	    super();
	    // TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HashMap<String , ArrayList<PlanEstudio>> hmPlanEstudio = new HashMap<>();
		
		for(Carrera carrera : carreraService.getAllCarrera())
		{	
			ArrayList<PlanEstudio> plan=new ArrayList<>();
			for(PlanEstudio planEstudio : planEstudioService.getPlanEstudioByidCarrera(carrera.getId()))
				plan.add(planEstudio);
			
			hmPlanEstudio.put(carrera.getNombre().replaceAll("\\\\n", ""),plan);
		}
		request.setAttribute("planEstudio", hmPlanEstudio);
		
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
  	  dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

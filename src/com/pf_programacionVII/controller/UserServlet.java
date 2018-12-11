package com.pf_programacionVII.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.PlanEstudio;
import com.pf_programacionVII.model.Tree;
import com.pf_programacionVII.model.User;
import com.pf_programacionVII.service.CarreraServiceImpl;
import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.MateriasServiceImpl;
import com.pf_programacionVII.service.PlanEstudioServiceImpl;
import com.pf_programacionVII.service.UserServiceImpl;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl userService = new UserServiceImpl();
	JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
	CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();
	String userinfo;
	HttpSession session;

   public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = (HttpSession) request.getSession(true);
		User actualUser =(User)session.getAttribute("actualUser");
		String carrera =carreraServiceImpl.getCarreraByidPlanEstudio(actualUser.getPlanStudioId()).getNombre();
		String str="";

		request.setAttribute("tree",userService.getStringFathersAndChildTree(actualUser,carrera).get(0) );
		request.setAttribute("noRealizado",userService.getStringFathersAndChildTree(actualUser,carrera).get(1) );

		
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tree.jsp");
  	  dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

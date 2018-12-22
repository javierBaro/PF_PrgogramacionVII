package com.pf_programacionVII.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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
	String userinfo;
	HttpSession session;
	String 	alertClass 	= "alert alert-danger invisible"; 
	String 	alertMsg 	= "No Hay Alerta";
	boolean attempts2 	= true;

   public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		session = (HttpSession) request.getSession(true);
		User actualUser =(User)session.getAttribute("actualUser");
		
		
		ArrayList<Object> arrayListHelper = userService.getStringFathersAndChildTree(actualUser);
		ArrayList<String> arrayListTree =(ArrayList<String>) arrayListHelper.get(0);
		ArrayList<Integer> arrayListCount =(ArrayList<Integer>) arrayListHelper.get(1);
		
		request.setAttribute("tree", arrayListTree.get(0));
		request.setAttribute("noRealizado",arrayListTree.get(1) );
		
		request.setAttribute("countNoRealizadas",arrayListCount.get(0));
		request.setAttribute("countRealizadas",arrayListCount.get(1));
		
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
  	  dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String 	passTry= "End";
		String alertClass= "";
		String alertMsg="";
		session =(HttpSession) request.getSession(true);
				// Exception Catching for User Login
				try {
					
					User user = userService.getUsuarioByUsuarioAndContrasena((String)request.getParameter("login_name"),(String)request.getParameter("contrasena"));	
					if(user!=null)
				      { 
				    		  //Session Startup
				    		  session.setAttribute("actualUser", user);
				    		  
				      		// Loading Login success
				      		doGet(request,response);
				    	  }else {
				        	  throw new Exception();
				    	  }
				      
				} catch (Exception e) {
					alertClass 	= "alert alert-danger visible";
					alertMsg 	= "Usuario no encontrado.";
					passTry 	= "PassTry: Failed. No User Found.";
					
					session.setAttribute("alertClass", alertClass);
				      session.setAttribute("alertMsg", alertMsg);
				      session.setAttribute("attempt", attempts2);
				      
				     response.sendRedirect("Login");

				}
				
			}
		
	
}

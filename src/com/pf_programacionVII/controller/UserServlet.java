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
		ArrayList<String> arrayList = userService.getStringFathersAndChildTree(actualUser);

		request.setAttribute("tree", arrayList.get(0));
		request.setAttribute("noRealizado",arrayList.get(1) );
		
	  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
  	  dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				User 	user 		= userService.getUsuarioByUsuario((String)request.getParameter("login_name"));
				String 	passTry 	= "End";
				String 	redirectURL = "/Login";
				
				// Exception Catching for User Login
				try {
					passTry 	= "Pass";
					userinfo 	= userService.getUsuarioByUsuario(request.getParameter("login_name")).toString();
					
				} catch (Exception e) {
					alertClass 	= "alert alert-danger visible";
					alertMsg 	= "Usuario no encontrado.";
					passTry 	= "PassTry: Failed. No User Found.";

				} finally {
					// Console Logs for Login
					System.out.println("Console: - LoginServlet.java | Stage 0 - End of TryCatch: " + "Result: " + passTry);
					
				}
				
				// Console Logs for Login
				System.out.println("Console: - LoginServlet.java | Stage 1 - Notificacion: " + alertMsg);
				System.out.println("Console: - LoginServlet.java | Stage 2 - Sent Data: " + "Username:" + request.getParameter("login_name") + " Password: " + request.getParameter("contrasena"));
				
		      if(user!=null)
		      {
		    	  // Console Logs for Login
		    	  System.out.println("Console: - LoginServlet.java | Stage 3 - Verification: User is Not Null");
		    	  System.out.println("Console: - LoginServlet.java | Stage 4 - Requested Data: " + "ReturnUsername" + user.getUsuario() + " ReturnPassword: " + user.getContrasena());
		    	  
		    	  if(user.getContrasena().equals(request.getParameter("contrasena"))) {
		    		  // Console Logs for Login
		    		  System.out.println("Console: - LoginServlet.java | Stage 5 - Authenticated: " + "Logged In");
		    		  System.out.println("Console: - LoginServlet.java | Stage 6 - Call Materias with doGet: ");
		    		  
		    		  //Session Startup
		    		  session =(HttpSession) request.getSession(true);
		    		  session.setAttribute("actualUser", user);
		    		  
		    		  alertClass 	= "alert alert-success visible";
		        	  alertMsg 		= "Login Exitoso.";
		        	  
		        	  // User actualUser =(User)session.getAttribute("user");
		        	  
		        	// Testing Login Confirmation
		      		request.setAttribute("alertClass", alertClass);
		      		request.setAttribute("alertMsg", alertMsg);
		      		request.setAttribute("attempt", attempts2);

		      		// Loading Login success
		      		doGet(request,response);
		    	  }else {
		    		  // Console Logs for Login
		    		  System.out.println("Console: - LoginServlet.java | Stage 5 - Not Authenticated: Wrong Password");

		    		  alertClass 	= "alert alert-danger visible";
		        	  alertMsg 		= "Usuario y/o Contrase�a incorrecta.";

		    	  }
		      }else {
		    	  // Console Logs for Login
		    	  System.out.println("Console: - LoginServlet.java | Stage 3 - Verification: No User Found");
		    	  
		      }
		      
		      request.setAttribute("alertClass", alertClass);
		      request.setAttribute("alertMsg", alertMsg);
		      request.setAttribute("attempt", attempts2);
		      
		      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirectURL);
		      dispatcher.forward(request, response);
			}
		
	
}

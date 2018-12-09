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
		String str="";

      
		str+="<html class=\" -moz-\" lang=\"es\">\n" + 
				"<head>\n" + 
				"<meta charset=\"utf-8\">\n" + 
				"<title></title>\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"static/ddf.css\" media=\"screen\">\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<div class=\"tree\">\n" + 
				"		<ul>" + 
				"			<li>" + 
				"				<a href=\"#\">"+carreraServiceImpl.getCarreraByidPlanEstudio(actualUser.getPlanStudioId()).getNombre()+"</a>\n" 
				+userService.getStringFathersAndChildTree(actualUser)+
				"			</li>\n" + 
				"		</ul>\n" + 
				"	</div>\n" + 
				"</body>\n" + 
			"</html>";

		response.getWriter().append(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userService.getUsuarioByUsuario((String)request.getParameter("login_name"));
		String passTry = "End";
		/*String redirectURL = "/pf_programacionVII/login.jsp";*/
		String redirectURL = "/login.jsp";
		String alertClass = "alert alert-danger invisible"; 
		String alertMsg = "No Hay Alerta";
		
		try {
			//System.out.println("Stage 0 - Try: " + "UserInput: " + user);
			passTry = "Pass";
			userinfo = userService.getUsuarioByUsuario(request.getParameter("login_name")).toString();
			
		}catch (Exception e) {
			//throw e;
			alertClass = "alert alert-danger visible";
			alertMsg = "Usuario no Existe.";
			request.setAttribute("alertClass", alertClass);
			request.setAttribute("alertMsg", alertMsg);
			//user = userService.getUsuarioByUsuario("Javier");
			passTry = "Failed. No User Found. Set to Default.";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirectURL);
			dispatcher.forward(request, response);
			//response.sendRedirect(redirectURL);
			
			
			//System.out.println("Stage 0 - Exception: " + e + "ForcedUserInput: " + user.getUsuario());
		} finally {
			System.out.println("Stage 0 - End of TryCatch: " + "Result: " + passTry);
			
		}
		
		//String str="No Entro",str2="Wrong Password" ;
		//alertMsg = (String)request.getAttribute("Name");
		//userinfo = userService.getUsuarioByUsuario(request.getParameter("login_name")).toString();
		//User user = userService.getUsuarioByUsuario((String)request.getParameter("login_name"));
		System.out.println("Stage 1 - Notificacion: " + alertMsg);
		System.out.println("Stage 2 - Sent Data: " + "Username:" + request.getParameter("login_name") + " Password: " + request.getParameter("contrasena"));
		//System.out.println("Stage 2.5 - Request: " );
		
      if(user!=null)
      {
    	  System.out.println("Stage 3 - Verification: User is Not Null");
    	  System.out.println("Stage 4 - Requested Data: " + "ReturnUsername" + user.getUsuario() + " ReturnPassword: " + user.getContrasena());
/*    	  response.getWriter().append("Login Intro:" + (String)request.getParameter("login_name") + "<br>");
    	  response.getWriter().append("Password Intro:" + (String)request.getParameter("contrasena") + "<br>");
    	  response.getWriter().append("Return Login:" + user.getUsuario() + "<br>");
    	  response.getWriter().append("Return Password:" + user.getContrasena() + "<br>");*/
    	  //System.out.println(user.getContrasena());
    	  if(user.getContrasena().equals(request.getParameter("contrasena"))) {
    		  System.out.println("Stage 5 - Authenticated: " + "Logged In");
    		  System.out.println("Stage 6 - CallMaterias with doGet: ");
    		  
    		  session =(HttpSession) request.getSession(true);
    		  session.setAttribute("actualUser", user);
    	     // User actualUser =(User)session.getAttribute("user");
    		  doGet(request, response);
    		  
    		  //response.getWriter().append("Adentro");
    	  }else {
    		  System.out.println("Stage 5 - Not Authenticated: Wrong Password");
    		  alertClass = "alert alert-danger visible";
        	  alertMsg = "Usuario y/o Contrase�a incorrecta.";
        	  request.setAttribute("alertClass", alertClass);
        	  request.setAttribute("alertMsg", alertMsg);
    		  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirectURL);
        	  dispatcher.forward(request, response);
    	  }
    	  //response.getWriter().append(str2);
    	  //alertMsg = "alert alert-danger visible";
      }else {
    	  
    	  System.out.println("Stage 3 - Verification: No User Found");
    	  
      }
      //response.getWriter().append(str);
		
	}

}

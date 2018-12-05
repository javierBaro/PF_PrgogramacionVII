package com.pf_programacionVII.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.User;
import com.pf_programacionVII.service.CarreraServiceImpl;
import com.pf_programacionVII.service.UserServiceImpl;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl userService = new UserServiceImpl();
	CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();
	String userinfo;
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str="";
		str+="<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Insert title here</title>\n" + 
				"</head>\n" + 
				"<body>"
			    + "<table>";	
			str+="<tr>";
			str+="<td>"+carreraServiceImpl.getCarreraByidCarrera(1).getNombre()+"</td>";
			str+="<td>"+carreraServiceImpl.getCarreraByidCarrera(1).getId()+"</td>";
			str+="<td>"+userinfo+"</td>";
			str+="</tr>";
		    str+="</table>"
				+ "</body>\n" + 
				"</html>";

		response.getWriter().append(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userinfo = userService.getUsuarioByUsuario(request.getParameter("login_name")).toString();
		
		doGet(request, response);
	}

}

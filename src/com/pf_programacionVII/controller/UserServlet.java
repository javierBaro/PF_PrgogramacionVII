package com.pf_programacionVII.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pf_programacionVII.model.User;
import com.pf_programacionVII.service.UserServiceImpl;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl userService = new UserServiceImpl();
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
		
		for(User user: userService.getAllUsuarios())
		{
			str+="<tr>";
			str+="<td>"+user.getId()+"</td>";
			str+="<td>"+user.getNombre()+"</td>";
			str+="<td>"+user.getUsuario()+"</td>";
			str+="<td>"+user.getContrasena()+"</td>";
			str+="<td>"+user.getPlanStudioId()+"</td>";
			str+="<td>"+user.getRolesId()+"</td>";
			str+="</tr>";
		}
		
		str+="<tr>";
		str+="<td>"+userService.getUsuarioByUsuario("javier").getNombre()+"</td>";
		str+="</tr>";
		str+="</table>"
				+ "</body>\n" + 
				"</html>";
		userService.updateUser(null);
		response.getWriter().append(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

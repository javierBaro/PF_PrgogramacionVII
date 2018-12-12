package com.pf_programacionVII.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pf_programacionVII.model.User;
import com.pf_programacionVII.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Registro")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl userService = new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre= request.getParameter("nombre");
		String contrasenia= request.getParameter("contrasenia");
		String usuario = request.getParameter("usuario");
		int planEstudioId = Integer.parseInt(request.getParameter("planEstudio"));
		
		User user = new User(nombre,usuario,contrasenia,planEstudioId,1);
		
		if(userService.insertAndReplicate(user)) 
		  request.setAttribute("Message", "Su cuenta se a creado con exito");
		else
			request.setAttribute("Message", "Ya existe un usuario con ese nombre de usuario");
		
		response.sendRedirect("Login");
	}

}

package com.pf_programacionVII.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String 	alertClass 	= "alert alert-warning visible"; 
	String 	alertMsg 	= "Fin de Session";
	boolean attempts2 	= true;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		
/*		boolean attempts2 = (boolean)request.getAttribute("attempt");*/
		if(session != null){

            session.invalidate();
            session = null;
            System.out.println("Console: - LogoutServlet.java | Session:" + session);
        }
		
		request.setAttribute("alertClass", alertClass);
		request.setAttribute("alertMsg", alertMsg);
		request.setAttribute("attempt", attempts2);
        //request.getRequestDispatcher("login.jsp").forward(request,response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

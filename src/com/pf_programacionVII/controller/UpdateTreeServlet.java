package com.pf_programacionVII.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.User;
import com.pf_programacionVII.model.UsuariosMaterias;
import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.MateriasServiceImpl;
import com.pf_programacionVII.service.UserServiceImpl;
import com.pf_programacionVII.service.UsuariosMateriasServiceImpl;

/**
 * Servlet implementation class UpdateTreeServlet
 */
@WebServlet("/UpdateTree")
public class UpdateTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserServiceImpl userService= new UserServiceImpl();
    UsuariosMateriasServiceImpl usuariosMateriasService = new UsuariosMateriasServiceImpl();
    JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
    HttpSession session;
	
    
    public UpdateTreeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 session =(HttpSession) request.getSession(true); 
		User actualUser=(User) session.getAttribute("actualUser");
		ArrayList<Object> arrayListHelper = userService.getStringFathersAndChildTree(actualUser);
		ArrayList<String> arrayListTree =(ArrayList<String>) arrayListHelper.get(0);
		request.setAttribute("checklist", userService.getMateriaRelizada(actualUser));
		
		
		request.setAttribute("tree", arrayListTree.get(0));
		request.setAttribute("noRealizado",arrayListTree.get(1) );
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updatetree.jsp");
   	  dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session =(HttpSession) request.getSession(true); 
		User actualUser=(User) session.getAttribute("actualUser");
		ArrayList<UsuariosMaterias> usuariosMaterias = new ArrayList<>();

		
		for (JoinPlanEstudioMaterias joinPlanEstudioMaterias : join.getJoinByidPlanEstudio(actualUser.getPlanStudioId()))
		{
			UsuariosMaterias usuariosMateriasDb= usuariosMateriasService.getUsuariosMateriasByJoinIdAndIdUsuario(joinPlanEstudioMaterias.getId(), actualUser.getId());
			if(request.getParameter(Integer.toString(joinPlanEstudioMaterias.getMateriaId()))!=null)
			{
				usuariosMateriasDb.setRealizado(1);
				usuariosMaterias.add(usuariosMateriasDb);
			}
			else
			{
				usuariosMateriasDb.setRealizado(0);
				usuariosMaterias.add(usuariosMateriasDb);
			}	
					
		}
	
		userService.UpdateUsuariosMaterias(usuariosMaterias);
		doGet(request, response);
	}

}

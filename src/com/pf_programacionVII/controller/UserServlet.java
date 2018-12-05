package com.pf_programacionVII.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pf_programacionVII.model.Carrera;
import com.pf_programacionVII.model.JoinPlanEstudioMaterias;
import com.pf_programacionVII.model.Materia;
import com.pf_programacionVII.model.Tree;
import com.pf_programacionVII.model.User;
import com.pf_programacionVII.service.CarreraServiceImpl;
import com.pf_programacionVII.service.JoinPlanEstudioMateriasServiceImpl;
import com.pf_programacionVII.service.MateriasServiceImpl;
import com.pf_programacionVII.service.UserServiceImpl;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserServiceImpl userService = new UserServiceImpl();
	CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();
	MateriasServiceImpl materiasServiceImpl = new MateriasServiceImpl();
	JoinPlanEstudioMateriasServiceImpl join = new JoinPlanEstudioMateriasServiceImpl();
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str="",str2="<ul>" ;
		HttpSession session = request.getSession();
        User actualUser =(User)session.getAttribute("user");
		
        
      for(JoinPlanEstudioMaterias joinFor : join.getJoinByidPlanEstudio(1))
      {
    	  if(joinFor.getPrerequisitoMateriaId()==0)
    	  {
    		  Materia materia = materiasServiceImpl.getMateriaByidMateria(joinFor.getMateriaId());
    		  Tree tree = new Tree(materia,1);
    		  str2+="<li>";
    		  str2 += tree.toStringTree();
    		  str2+="</li>";
    		  
    	  }
      }
      str2+="</ul>";
		
		str+="<html class=\" -moz-\" lang=\"en\">\n" + 
				"<head>\n" + 
				"<meta charset=\"utf-8\">\n" + 
				"<title></title>\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"static/ddf.css\" media=\"screen\">\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<div class=\"tree\">\n" + 
				"		<ul>" + 
				"			<li>" + 
				"				<a href=\"#\">Ingenieria en systema</a>\n" 
				+str2+
				"			</li>\n" + 
				"		</ul>\n" + 
				"	</div>\n" + 
				"</body>\n" + 
				"</html>";

		response.getWriter().append(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		doGet(request, response);
	}

}

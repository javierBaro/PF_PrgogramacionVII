
<%@page import="java.util.ArrayList"%>
<%@page import="com.pf_programacionVII.model.MateriaRealizada"%>
<%@page import="com.pf_programacionVII.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//session.getAttribute("actualUser");
	User actualUser = (User)session.getAttribute("actualUser");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags-->

	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="au theme template">
  <meta name="author" content="Hau Nguyen">
  <meta name="keywords" content="au theme template">
  
<title>Update Materias</title>

<link rel="stylesheet" type="text/css" href="static/ddf.css">
<!-- Fontfaces CSS-->
  <link href="static/dashboardstyle/css/font-face.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

  <!-- Bootstrap CSS-->
  <link href="static/dashboardstyle/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

  <!-- Vendor CSS-->
  <link href="static/dashboardstyle/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/wow/animate.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/slick/slick.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/select2/select2.min.css" rel="stylesheet" media="all">
  <link href="static/dashboardstyle/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

  <!-- Main CSS-->
  <link href="static/dashboardstyle/css/theme.css" rel="stylesheet" media="all">
  
  <!-- Tree Scripts -->
  <script type="text/javascript" src="static/createjs-2015.05.21.min.js"></script>
  <script type="text/javascript" src="static/flow.min.js"></script>
  <style>
  
  .materiaTreeScroll {
  overflow: scroll;
  overflow-x: scroll;
  overflow-y:hidden
}
  </style>
</head>

<body class="animsition">
  <div class="page-wrapper">
      <!-- HEADER MOBILE-->
      <header class="header-mobile d-block d-lg-none">
          <div class="header-mobile__bar">
              <div class="container-fluid">
                  <div class="header-mobile-inner">
                      <a class="logo" href="index.html">
                          <img src="static/dashboardstyle/images/icon/logo.png" alt="MateriasTree" />
                      </a>
                      <button class="hamburger hamburger--slider" type="button">
                          <span class="hamburger-box">
                              <span class="hamburger-inner"></span>
                          </span>
                      </button>
                  </div>
              </div>
          </div>
          <nav class="navbar-mobile">
              <div class="container-fluid">
                  <ul class="navbar-mobile__list list-unstyled">
                      <li class="has-sub">
                          <a class="js-arrow" href="User">
                              <i class="fas fa-tachometer-alt"></i>Dashboard</a>`
                      </li>
                      <li>
                          <a href="UpdateTree">
                              <i class="fas fa-check-square"></i>Actualizar Materias</a>
                      </li>

                  </ul>
              </div>
          </nav>
      </header>
      <!-- END HEADER MOBILE-->

      <!-- MENU SIDEBAR-->
      <aside class="menu-sidebar d-none d-lg-block">
          <div class="logo">
              <a href="#">
                  <img src="static/dashboardstyle/images/icon/logo.png" alt="Cool Admin" />
              </a>
          </div>
          <div class="menu-sidebar__content js-scrollbar1">
              <nav class="navbar-sidebar">
                  <ul class="list-unstyled navbar__list">
                      <li class="has-sub">
                          <a class="js-arrow" href="User">
                              <i class="fas fa-tachometer-alt"></i>Dashboard</a>
                      </li>
                      <li class="active">
                          <a href="UpdateTree">
                              <!-- <i class="fas fa-chart-bar"></i>Actualizar Materias</a> -->
                              <i class="fas fa-check-square"></i>Actualizar Materias</a>
                      </li>
                  </ul>
              </nav>
          </div>
      </aside>
      <!-- END MENU SIDEBAR-->

      <!-- PAGE CONTAINER-->
      <div class="page-container">
          <!-- HEADER DESKTOP-->
          <header class="header-desktop">
              <div class="section__content section__content--p30">
                  <div class="container-fluid">
                      <div class="header-wrap">
                          <form class="form-header" action="" method="POST">
                              <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                              <button class="au-btn--submit" type="submit">
                                  <i class="zmdi zmdi-search"></i>
                              </button>
                          </form>
                          <div class="header-button">
                              <div class="noti-wrap d-none">
                                  <div class="noti__item js-item-menu">
                                      <i class="zmdi zmdi-comment-more"></i>
                                      <span class="quantity">1</span>
                                      <div class="mess-dropdown js-dropdown">
                                          <div class="mess__title">
                                              <p>You have 2 news message</p>
                                          </div>
                                          <div class="mess__item">
                                              <div class="image img-cir img-40">
                                                  <img src="static/dashboardstyle/images/icon/avatar-06.jpg" alt="Michelle Moreno" />
                                              </div>
                                              <div class="content">
                                                  <h6>Michelle Moreno</h6>
                                                  <p>Have sent a photo</p>
                                                  <span class="time">3 min ago</span>
                                              </div>
                                          </div>
                                          <div class="mess__item">
                                              <div class="image img-cir img-40">
                                                  <img src="static/dashboardstyle/images/icon/avatar-04.jpg" alt="Diane Myers" />
                                              </div>
                                              <div class="content">
                                                  <h6>Diane Myers</h6>
                                                  <p>You are now connected on message</p>
                                                  <span class="time">Yesterday</span>
                                              </div>
                                          </div>
                                          <div class="mess__footer">
                                              <a href="#">View all messages</a>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="noti__item js-item-menu">
                                      <i class="zmdi zmdi-email"></i>
                                      <span class="quantity">1</span>
                                      <div class="email-dropdown js-dropdown">
                                          <div class="email__title">
                                              <p>You have 3 New Emails</p>
                                          </div>
                                          <div class="email__item">
                                              <div class="image img-cir img-40">
                                                  <img src="static/dashboardstyle/images/icon/avatar-06.jpg" alt="Cynthia Harvey" />
                                              </div>
                                              <div class="content">
                                                  <p>Meeting about new dashboard...</p>
                                                  <span>Cynthia Harvey, 3 min ago</span>
                                              </div>
                                          </div>
                                          <div class="email__item">
                                              <div class="image img-cir img-40">
                                                  <img src="static/dashboardstyle/images/icon/avatar-05.jpg" alt="Cynthia Harvey" />
                                              </div>
                                              <div class="content">
                                                  <p>Meeting about new dashboard...</p>
                                                  <span>Cynthia Harvey, Yesterday</span>
                                              </div>
                                          </div>
                                          <div class="email__item">
                                              <div class="image img-cir img-40">
                                                  <img src="static/dashboardstyle/images/icon/avatar-04.jpg" alt="Cynthia Harvey" />
                                              </div>
                                              <div class="content">
                                                  <p>Meeting about new dashboard...</p>
                                                  <span>Cynthia Harvey, April 12,,2018</span>
                                              </div>
                                          </div>
                                          <div class="email__footer">
                                              <a href="#">See all emails</a>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="noti__item js-item-menu">
                                      <i class="zmdi zmdi-notifications"></i>
                                      <span class="quantity">3</span>
                                      <div class="notifi-dropdown js-dropdown">
                                          <div class="notifi__title">
                                              <p>You have 3 Notifications</p>
                                          </div>
                                          <div class="notifi__item">
                                              <div class="bg-c1 img-cir img-40">
                                                  <i class="zmdi zmdi-email-open"></i>
                                              </div>
                                              <div class="content">
                                                  <p>You got a email notification</p>
                                                  <span class="date">April 12, 2018 06:50</span>
                                              </div>
                                          </div>
                                          <div class="notifi__item">
                                              <div class="bg-c2 img-cir img-40">
                                                  <i class="zmdi zmdi-account-box"></i>
                                              </div>
                                              <div class="content">
                                                  <p>Your account has been blocked</p>
                                                  <span class="date">April 12, 2018 06:50</span>
                                              </div>
                                          </div>
                                          <div class="notifi__item">
                                              <div class="bg-c3 img-cir img-40">
                                                  <i class="zmdi zmdi-file-text"></i>
                                              </div>
                                              <div class="content">
                                                  <p>You got a new file</p>
                                                  <span class="date">April 12, 2018 06:50</span>
                                              </div>
                                          </div>
                                          <div class="notifi__footer">
                                              <a href="#">All notifications</a>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                              <div class="account-wrap">
                                  <div class="account-item clearfix js-item-menu">
                                      <div class="image">
                                          <img src="static/dashboardstyle/images/icon/avatar-01.jpg" alt="John Doe" />
                                      </div>
                                      <div class="content">
                                          <a class="js-acc-btn" href="#"><%= actualUser.getNombre() %></a>
                                      </div>
                                      <div class="account-dropdown js-dropdown">
                                          <div class="info clearfix">
                                              <div class="image">
                                                  <a href="#">
                                                      <img src="static/dashboardstyle/images/icon/avatar-01.jpg" alt="John Doe" />
                                                  </a>
                                              </div>
                                              <div class="content">
                                                  <h5 class="name">
                                                      <a href="#"><%= actualUser.getNombre() %></a>
                                                  </h5>
                                                  <span class="email"><%= actualUser.getUsuario() + "@materiasTree.com" %></span>
                                              </div>
                                          </div>
                                          <div class="account-dropdown__body d-none">
                                              <div class="account-dropdown__item">
                                                  <a href="#">
                                                      <i class="zmdi zmdi-account"></i>Account</a>
                                              </div>
                                              <div class="account-dropdown__item">
                                                  <a href="#">
                                                      <i class="zmdi zmdi-settings"></i>Setting</a>
                                              </div>
                                              <div class="account-dropdown__item">
                                                  <a href="#">
                                                      <i class="zmdi zmdi-money-box"></i>Billing</a>
                                              </div>
                                          </div>
                                          <div class="account-dropdown__footer">
                                              <a href="Logout">
                                                  <i class="zmdi zmdi-power"></i>Logout</a>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </header>
          <!-- HEADER DESKTOP-->
          
           <%
		String tree = "", noRealizado = "";
       ArrayList<MateriaRealizada> materiaRealizadas= new ArrayList<MateriaRealizada>();
		if (request.getAttribute("tree") != null) {
			tree = request.getAttribute("tree").toString();
		}
		if (request.getAttribute("noRealizado") != null) {
			noRealizado = request.getAttribute("noRealizado").toString();
		}
		if (request.getAttribute("checklist") != null) {
			materiaRealizadas =(ArrayList<MateriaRealizada>) request.getAttribute("checklist");
		}
	%>
       
<!-- <form action="UpdateTree" method="post"> -->
<%-- <% 

for(MateriaRealizada materiaRealizada : materiaRealizadas){
	if(materiaRealizada.getRealizada())
	{
		%>
		<input type="checkbox" name="<%=materiaRealizada.getId()%>" checked><%=materiaRealizada.getNombre()%>
		<%
	}
		else
		{
			%>
	<input type="checkbox" name="<%=materiaRealizada.getId()%>" ><%=materiaRealizada.getNombre()%>
	<%
	}
}
%> --%>
<!-- <button type="submit" >Guardar</button> -->
<!-- </form> -->
          
          <!-- MAIN CONTENT-->
          <div class="main-content">
              <div class="section__content section__content--p30">
                  <div class="container-fluid">
                  <form action="UpdateTree" method="post">
                      <div class="row">
                          <div class="col-md-12">
                              <div class="overview-wrap">
                                  <h2 class="title-1">Actualizacion de Materias</h2>
                                  <div class="col-md-6"></div>
                                  <button class="au-btn au-btn-icon au-btn--blue" type="submit">
                                      <i class="zmdi zmdi-plus"></i>Guardar</button>
                                  <button class="au-btn au-btn-icon au-btn--blue" onclick="myFunction()">
                                      <i class="zmdi zmdi-plus"></i>Mostrar</button>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row m-t-25">
	                      <div class="col-md col-lg" id="userStats" style="display: none;">
	                          <div class="col-sm-6 col-lg-3">
	                              <div class="overview-item overview-item--c1">
	                                  <div class="overview__inner">
	                                      <div class="overview-box clearfix">
	                                          <div class="icon">
	                                              <i class="zmdi zmdi-account-o"></i>
	                                          </div>
	                                          <div class="text">
	                                              <h2>10368</h2>
	                                              <span>members online</span>
	                                          </div>
	                                      </div>
	                                      <div class="overview-chart">
	                                          <canvas id="widgetChart1"></canvas>
	                                      </div>
	                                  </div>
	                              </div>
	                          </div>
	                          <div class="col-sm-6 col-lg-3">
	                              <div class="overview-item overview-item--c2">
	                                  <div class="overview__inner">
	                                      <div class="overview-box clearfix">
	                                          <div class="icon">
	                                              <i class="zmdi zmdi-shopping-cart"></i>
	                                          </div>
	                                          <div class="text">
	                                              <h2>388,688</h2>
	                                              <span>items solid</span>
	                                          </div>
	                                      </div>
	                                      <div class="overview-chart">
	                                          <canvas id="widgetChart2"></canvas>
	                                      </div>
	                                  </div>
	                              </div>
	                          </div>
	                          <div class="col-sm-6 col-lg-3">
	                              <div class="overview-item overview-item--c3">
	                                  <div class="overview__inner">
	                                      <div class="overview-box clearfix">
	                                          <div class="icon">
	                                              <i class="zmdi zmdi-calendar-note"></i>
	                                          </div>
	                                          <div class="text">
	                                              <h2>1,086</h2>
	                                              <span>this week</span>
	                                          </div>
	                                      </div>
	                                      <div class="overview-chart">
	                                          <canvas id="widgetChart3"></canvas>
	                                      </div>
	                                  </div>
	                              </div>
	                          </div>
	                          <div class="col-sm-6 col-lg-3">
	                              <div class="overview-item overview-item--c4">
	                                  <div class="overview__inner">
	                                      <div class="overview-box clearfix">
	                                          <div class="icon">
	                                              <i class="zmdi zmdi-money"></i>
	                                          </div>
	                                          <div class="text">
	                                              <h2>$1,060,386</h2>
	                                              <span>total earnings</span>
	                                          </div>
	                                      </div>
	                                      <div class="overview-chart">
	                                          <canvas id="widgetChart4"></canvas>
	                                      </div>
	                                  </div>
	                              </div>
	                          </div>
	                      </div>
                      </div>
                      <div class="row">
                          <div class="col-lg-12" id="materiaUpdateDiagram">
                              <div class="au-card chart-percent-card">
                                  <div class="au-card-inner">
                                      <h3 class="title-3 tm-b-5">Materias</h3>
                                      <div class="row no-gutters">
                                          <div class="col-xl-12 materiaTreeScroll">
												<canvas id="canvas1" width="3000" height="900"></canvas>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row d-none">
                          <div class="col-lg-6">
                              <div class="au-card recent-report">
                                  <div class="au-card-inner">
                                      <h3 class="title-2">recent reports</h3>
                                      <div class="chart-info">
                                          <div class="chart-info__left">
                                              <div class="chart-note">
                                                  <span class="dot dot--blue"></span>
                                                  <span>products</span>
                                              </div>
                                              <div class="chart-note mr-0">
                                                  <span class="dot dot--green"></span>
                                                  <span>services</span>
                                              </div>
                                          </div>
                                          <div class="chart-info__right">
                                              <div class="chart-statis">
                                                  <span class="index incre">
                                                      <i class="zmdi zmdi-long-arrow-up"></i>25%</span>
                                                  <span class="label">products</span>
                                              </div>
                                              <div class="chart-statis mr-0">
                                                  <span class="index decre">
                                                      <i class="zmdi zmdi-long-arrow-down"></i>10%</span>
                                                  <span class="label">services</span>
                                              </div>
                                          </div>
                                      </div>
                                      <div class="recent-report__chart">
                                          <canvas id="recent-rep-chart"></canvas>
                                      </div>
                                  </div>
                              </div>
                          </div>
                          <div class="col-lg-6">
                              <div class="au-card chart-percent-card">
                                  <div class="au-card-inner">
                                      <h3 class="title-2 tm-b-5">char by %</h3>
                                      <div class="row no-gutters">
                                          <div class="col-xl-6">
                                              <div class="chart-note-wrap">
                                                  <div class="chart-note mr-0 d-block">
                                                      <span class="dot dot--blue"></span>
                                                      <span>products</span>
                                                  </div>
                                                  <div class="chart-note mr-0 d-block">
                                                      <span class="dot dot--red"></span>
                                                      <span>services</span>
                                                  </div>
                                              </div>
                                          </div>
                                          <div class="col-xl-6">
                                              <div class="percent-chart">
                                                  <canvas id="percent-chart"></canvas>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>                           
                          
                      </div>
                      
                      <div class="row">
                          <div class="col-lg-12">
                              <h2 class="title-1 m-b-25">Actualizacion de Materias</h2>
                              <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                  <div class="au-card-title" style="background-image:url('static/dashboardstyle/images/bg-title-01.jpg');">
                                      <div class="bg-overlay bg-overlay--blue"></div>
                                      <h3>
                                          <i class="zmdi zmdi-account-calendar"></i>Materias de Plan de Estudio</h3>
                                      <button class="au-btn-plus">
                                          <i class="zmdi zmdi-plus"></i>
                                      </button>
                                  </div>
                                  <div class="au-task js-list-load">
                                      <div class="au-task__title">
                                          <p>Materias disponibles en Plan de Estudio</p>
                                      </div>
                                      <div class="au-task-list js-scrollbar3">
                                                                                    
                                          <% 

for(MateriaRealizada materiaRealizada : materiaRealizadas){
	if(materiaRealizada.getRealizada())
	{
		%>
		<%-- <input type="checkbox" name="<%=materiaRealizada.getId()%>" checked><%=materiaRealizada.getNombre()%> --%>
		<div class="au-task__item au-task__item--warning js-load-item">
                                              <div class="au-task__item-inner">
                                                  <h5 class="task">
                                                      <a href="#"><input type="checkbox" name="<%=materiaRealizada.getId()%>" checked><%=materiaRealizada.getNombre()%></a>
                                                  </h5>
                                                  <span class="time">11:00 AM</span>
                                              </div>
                                          </div>
		<%
	}
		else
		{
			%>
	<%-- <input type="checkbox" name="<%=materiaRealizada.getId()%>" ><%=materiaRealizada.getNombre()%> --%>
	<div class="au-task__item au-task__item--warning js-load-item">
                                              <div class="au-task__item-inner">
                                                  <h5 class="task">
                                                      <a href="#"><input type="checkbox" name="<%=materiaRealizada.getId()%>" ><%=materiaRealizada.getNombre()%></a>
                                                  </h5>
                                                  <span class="time">11:00 AM</span>
                                              </div>
                                          </div>
	<%
	}
}
%>
                                          
                                      </div>
                                      <div class="au-task__footer">
                                          <button class="au-btn au-btn-load js-load-btn">load more</button>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      </form>
                      
                      <div class="row">
                          <div class="col-md-12">
                              <div class="copyright">
                                  <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <!-- END MAIN CONTENT-->
          
          <!-- END PAGE CONTAINER-->
      </div>

  </div>

  <!-- Jquery JS-->
  <script src="static/dashboardstyle/vendor/jquery-3.2.1.min.js"></script>
  <!-- Bootstrap JS-->
  <script src="static/dashboardstyle/vendor/bootstrap-4.1/popper.min.js"></script>
  <script src="static/dashboardstyle/vendor/bootstrap-4.1/bootstrap.min.js"></script>
  <!-- Vendor JS       -->
  <script src="static/dashboardstyle/vendor/slick/slick.min.js">
  </script>
  <script src="static/dashboardstyle/vendor/wow/wow.min.js"></script>
  <script src="static/dashboardstyle/vendor/animsition/animsition.min.js"></script>
  <script src="static/dashboardstyle/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
  </script>
  <script src="static/dashboardstyle/vendor/counter-up/jquery.waypoints.min.js"></script>
  <script src="static/dashboardstyle/vendor/counter-up/jquery.counterup.min.js">
  </script>
  <script src="static/dashboardstyle/vendor/circle-progress/circle-progress.min.js"></script>
  <script src="static/dashboardstyle/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
  <script src="static/dashboardstyle/vendor/chartjs/Chart.bundle.min.js"></script>
  <script src="static/dashboardstyle/vendor/select2/select2.min.js"></script>

    <script type="text/javascript">
	   window.addEventListener("load", func);
	    
	    function func(){
	        console.log("LOADED");
	        
	        var a = new flowjs.DiGraph();
	        a.addPaths([<%=tree%>]);
	        
	        var notRed = [<%=noRealizado%>];
	        
	        // Advanced Example with loading animation
	        var cf = new flowjs.DiFlowChart("canvas1", a);
	        cf.draw();
	        simuLoad(cf, a, notRed );    
	    }
	    
	    
	    function simuLoad(flowChart, graph, notRed ){
	        var walker = new flowjs.GraphWalker(graph);
	        walker.forEach(function(node){
	        	var connect = true;
	        	for (var i=0, len=notRed.length; i<len; i++) {
	        	if(node.id== notRed [i])
	        		connect=false;
	        	}
	            flowChart.updateItem(node.id, function(item){   	  
	                    if(connect == true)
	                    	{
	                    	item.flowItem.color = "red";
	                    if (item.connectors === undefined){return;}
	                    item.connectors.forEach(function(conn){ conn.color = "red";});
	                    	}
	            });
	
	        }, this);
	
	    }
         
    </script> 
    <script>
    function myFunction() {
  	  var x = document.getElementById("materiaUpdateDiagram");
  	  /* var x = document.getElementsByClassName("userStats"); */
  	  if (x.style.display === "none") {
  	    x.style.display = "flex";
  	  } else {
  	    x.style.display = "none";
  	  }
  	}
    
    </script>
    
    <!-- Main JS-->
    <script src="static/dashboardstyle/js/main.js"></script>
    
</body>
</html>
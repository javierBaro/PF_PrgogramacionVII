<%@page import="com.pf_programacionVII.model.PlanEstudio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pf_programacionVII.model.Carrera"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.pf_programacionVII.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% 
//session.getAttribute("actualUser");
User actualUser = (User)session.getAttribute("actualUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags-->

   	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">
    
	<title>Dashboard</title>

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
    
    
    <script type="text/javascript" src="static/createjs-2015.05.21.min.js"></script>
    <script type="text/javascript" src="static/flow.min.js"></script>
</head>

<body class="animsition">
<%
		String tree = "", noRealizado = "";
		if (request.getAttribute("tree") != null) {
			tree = request.getAttribute("tree").toString();
		}
		if (request.getAttribute("noRealizado") != null) {
			noRealizado = request.getAttribute("noRealizado").toString();
		}
	%>
        <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="static/dashboardstyle/images/icon/materias.png" alt="MateriasTree">
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
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Dashboard</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                <li>
                                    <a href="index.html">Dashboard 1</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="form.html">
                                <i class="far fa-check-square"></i>Forms</a>
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
                    <img src="static/dashboardstyle/images/icon/materias.png" alt="Cool Admin">
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1 ps ps--active-y">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="User">
                                <i class="fas fa-tachometer-alt"></i>Panel Principal</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                            </ul>
                        </li> 
                        <li>
                            <a href="UpdateTree">
                                <i class="far fa-check-square"></i>Actualizar Materias</a>
                        </li>
                    </ul>
                </nav>
            <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 307px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 195px;"></div></div></div>
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
                                <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports...">
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                            <div class="header-button">
                                
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="static/dashboardstyle/images/icon/avatar-01.jpg" alt="John Doe">
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">Eduardo Augstine</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="static/dashboardstyle/images/icon/avatar-01.jpg" alt="John Doe">
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#">Eduardo Augstine</a>
                                                    </h5>
                                                    <span class="email">johndoe@example.com</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
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

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="overview-wrap">
                                    <h2 class="title-1">Vista General</h2>
                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row m-t-25 " >
                            <div class="col-lg-12 scroll">
                                <div class="au-card recent-report">
                                    <div class="au-card-inner">
                                        <h3 class="title-2">Diagrama de su Plan de Estudio</h3>
                                            </div>
                                            
                                           <div class="recent-report__chart"><div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                            <!-- <canvas id="recent-rep-chart"  style="display: block;" width="390" class="chartjs-render-monitor"></canvas> -->
                                            <canvas id="canvas1" height="900" style="display: block; width: 2100px; height: 900px;" width="2900" class="chartjs-render-monitor" ></canvas>
                                        </div>
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
                                                <div class="percent-chart"><div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                                                    <canvas id="percent-chart" height="280" style="display: block; width: 196px; height: 280px;" width="196" class="chartjs-render-monitor"></canvas>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
 
                        
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
    <script src="static/dashboardstyle/vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="static/dashboardstyle/js/main.js"></script>

</body>

</html>
<!-- end document-->

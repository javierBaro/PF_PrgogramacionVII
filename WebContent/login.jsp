<%@page import="com.pf_programacionVII.model.PlanEstudio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pf_programacionVII.model.Carrera"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js?val=0"></script>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="row align-items-center ">
			<div class="col-6 mx-auto">

				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li class="nav-item"><a class="nav-link active"
						data-toggle="tab" href="#home">Login</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#menu1">Registro</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div id="home" class="container tab-pane active ">

						<form  method="post" action="User">
							<br>
							<div class="form-group row">
								<div class="col-md-4"></div>
								<div class="col-md-6">
									<label>Email / Usuario</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"><i
												class="fa fa-envelope-open-o" aria-hidden="true"></i></span>
										</div>
										<input type="text" class="form-control" name="login_name"
											value="" pattern=".{4,}" title="Cuatro(4) o mas caracteres"
											required>
									</div>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-md-4"></div>
								<div class="col-md-6">
									<label>Contraseña</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-unlock"
												aria-hidden="true"></i></span>
										</div>
										<input type="password" name="contrasena" class="form-control"
											required="">
									</div>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-md-4"></div>
								<div class="col-md-6">
									<input type="submit" class="btn btn-primary btn-lg btn-block "
										value="Login" name="submit">
								</div>
							</div>

						</form>
					</div>


					<div id="menu1" class="container tab-pane fade">
						<br>
						<form id="form_reg" action="Registro" method="post" >

							<div class="form-group row">
								<label for="user" class="col-md-4 col-form-label text-md-right">Usuario</label>
								<div class="col-md-6">
									<input type="text" id="user" class="form-control"
										name="usuario" required>
								</div>
							</div>


							<div class="form-group row">
								<label for="contrasenia" class="col-md-4 col-form-label text-md-right" >Contraseña</label>
								<div class="col-md-6">
									<input type="password" id="pass1" class="form-control" name="contrasenia" required>
								</div>
							</div>

							<div class="form-group row">
								<label for="contrasenia_rpt" class="col-md-4 col-form-label text-md-right">Repetir contraseña</label>
								<div class="col-md-6">
									<input type="password" id="pass2"	class="form-control" name="contrasenia_rpt" required>
								</div>
							</div>
                            <div class="form-group row">
                            <div class="col-md-4"></div>
                            <div class="col-md-6">
                            <h5 id="alert_confirm" style="font-size:small;color:crimson;"></h5>
                            </div>
                            </div>
                            
							<div class="form-group row">
								<label for="plan_estudio"
									class="col-md-4 col-form-label text-md-right">Plan de estudio</label>
								<div class="col-md-6">
									<select class="form-control" id="plan_estudio" name="planEstudio" required>
										<% 
										 HashMap<String,ArrayList<PlanEstudio>> hm= new HashMap<>();
										
										if(request.getAttribute("planEstudio")!=null)
										{
										 hm=(HashMap<String,ArrayList<PlanEstudio>>) request.getAttribute("planEstudio");		 
										 for(Map.Entry<String,ArrayList<PlanEstudio>> pair : hm.entrySet())
										 {
										       %>
										<option disabled>--<%=pair.getKey()%>--</option>
										<%
										       for(PlanEstudio plan : pair.getValue())
										       {
										    	   %>
										<option value="<%=plan.getId()%>"><%=plan.getFechaPlanEstudio()%></option>
										<%
										       }
										    }
										}
										%>
									</select>
								</div>
							</div>

							<div class="col-md-6 offset-md-4">
								<button type="submit" value="submit" class="btn btn-primary">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="static/confirm_password.js?=112"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>
 	<% 
	String alertClass = "alert alert-danger invisible"; 
	String alertMsg = "Usuario y/o Contraseña incorrecta.";
	/* request.setAttribute("alertClass", alertClass);
	request.setAttribute("alertMsg", alertMsg); */
	alertMsg = (String)request.getAttribute("alertMsg");
	alertClass = (String)request.getAttribute("alertClass");
	%>
    <div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="card">
				<h4 class="card-header">Login</h4>
				<div class="card-body">
					
				 	<div class=<%= '"' + alertClass + '"' %> role="alert"> 
						<%= alertMsg %>
					</div>
					<form data-toggle="validator" role="form" method="post" action="User">
						<input type="hidden" class="hide" id="csrf_token" name="csrf_token" value="C8nPqbqTxzcML7Hw0jLRu41ry5b9a10a0e2bc2">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Email / Usuario</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-envelope-open-o" aria-hidden="true"></i></span>
										</div>
										<input type="text" class="form-control" name="login_name" value="" pattern=".{4,}" title="Cuatro(4) o mas caracteres" required="">
									</div>
									<div class="help-block with-errors text-danger"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Contraseña</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-unlock" aria-hidden="true"></i></span>
										</div>
										<input type="password" name="contrasena" class="form-control" required="">
									</div>
									<div class="help-block with-errors text-danger"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="checkbox checkbox-primary">
								<input id="checkbox_remember" type="checkbox" name="remember">
								<label for="checkbox_remember"> Recordar</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<input type="hidden" name="redirect" value="">
								<input type="submit" class="btn btn-primary btn-lg btn-block" value="Login" name="submit">
							</div>
						</div>
					</form>
					<div class="clear"></div>
					<i class="fa fa-user fa-fw"></i> ¿No tienes cuenta aún? <a href="#">Regístrate</a><br>
					<i class="fa fa-undo fa-fw"></i> ¿Se te olvidó tu contraseña? <a href="#">Recupérala</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
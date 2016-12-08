<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Usuario</title>
</head>
<body>
<h1>Ingreso de Datos de Usuario</h1>
<form action = "RegistrarPerfil" method = "post">
	 
	 
	 <p><%= request.getAttribute("msgExito") %></p>
	 <div>
	  Usuario: <input type = "text" name = "txtUsuario"/>
	</div>
	<div>
		Perfil: <input type = "text" name = "txtPerfil"/>
	</div>
	<div>
		Clave: <input type = "password" name = "txtClave"/>
	</div>	
	<div>
		Confirmación Clave: <input type = "password" name = "txtConfirmacionClave"/>
	</div>	
	<div>
			<input type = "submit" value="Crear usuario"/>
	</div>	
	</form>

</body>
</html>
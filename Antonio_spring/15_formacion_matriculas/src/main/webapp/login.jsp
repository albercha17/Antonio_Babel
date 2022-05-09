<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"  href="css/global.css">
</head>
<body>
	<center>
			

			<div id="loginContainer">
				<h1>LOGIN</h1>
				<form action="Login" method="post">
				
					<p class="inputs">Nombre de Usuario  <input type="text" name="usuario" placeholder="Nombre de Usuario" required /></p>
					<p class="inputs">Contraseña  <input type="password" name="password" placeholder="Contraseña" required /></p>
					
					<input class="botones" type="submit" value="Acceder" />

				</form>

			</div>
			</center>
</body>
</html>
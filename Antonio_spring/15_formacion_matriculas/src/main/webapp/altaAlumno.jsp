<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Alumno</title>
<link rel="stylesheet" href="css/global.css">
</head>

<div class="divAlta">

	<form action="AltaAlumno" method="post">
		<center> 
		<h1> ALTA DE ALUMNO</h1>
		
		<h2>Usuario</h2>
		<span><input type="text" name="usuario"
			placeholder="Nombre de Usuario" required /></span>
		<h2>Contraseņa</h2>
		<span><input type="password" name="password"
			placeholder="Contraseņa" required /></span>
		<h2>Nombre</h2>
		<span><input type="text" name="nombre"
			placeholder="nombre" required /></span>
		<h2>Email</h2>
		<span><input type="text" name="email"
			placeholder="email" required /></span>
		<h2>Edad</h2>
		<span><input type="number" name="edad"
			placeholder="edad" required /></span>
			<br> <br> <input type="submit" class="botones"
			value="Guardar Alumno" />

	</form>
	</center>
</div>
</html>
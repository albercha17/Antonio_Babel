<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Curso</title>
<link rel="stylesheet"  href="css/global.css">
</head>
<body>
<div class="divAlta">

	<form action="AltaCurso" method="post">
<center> 
		<h1> ALTA DE CURSO</h1>
		
		<h2>Nombre</h2>
		<span><input type="text" name="nombre"
			placeholder="Nombre del Curso" required /></span>
		<h2>Duracion</h2>
		<span><input type="number" name="duracion"
			placeholder="Duracion" required /></span>
		<h2>Precio</h2>
		<span><input type="number" name="precio"
			placeholder="Precio" required /></span>
		<h2>Fecha de Inicio</h2>
		<span><input type="date" name="fechaInicio"
			placeholder="Fecha de Inicio" required /></span>
			<br><br> <input type="submit" class="botones"
			value="Guardar Curso" />

	</form>
	</center>
</div>
</body>
</html>
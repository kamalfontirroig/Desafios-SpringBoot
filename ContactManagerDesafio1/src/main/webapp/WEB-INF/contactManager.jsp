<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Contact Manager</title>
</head>
<script type="text/javascript">
var idEliminar;

function cambiarIdABorrar(id){
	idEliminar = id;
}
function borrarContacto(){
	window.location.href ="/contactManager/borrarContacto/?id=" + idEliminar;
}
</script>
<body>
	<form:form id="frmAcciones" action="/contactManager/" method="post"
		modelAttribute="contacto" class="form col-6">
		<div>
			<legend>Mantenedor de Contactos</legend>
			<table class="table">
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="nombre" required /></td>
					<td>Apellido Paterno:</td>
					<td><input type="text" name="apellido1" required /></td>
					<td>Apellido Materno:</td>
					<td><input type="text" name="apellido2" required /></td>
				</tr>
				<tr>
					<td>Dirección:</td>
					<td><input type="text" name="direccion" required /></td>
					<td>Teléfono:</td>
					<td><input type="number" name="telefono" required /></td>
				</tr>
				<tr>
					<td colspan="6"><input type="submit" value="Agregar" /> <input
						type="button" value="Eliminar" onclick="borrarContacto()" /></td>
				</tr>
			</table>
		</div>
	</form:form>

	<div class="text-right col-12">
		<div class="d-inline-block col-6">
			<table class="table text-left">
				<thead>
					<th></th>
					<th>Nombre</th>
					<th>Paterno</th>
					<th>Materno</th>
					<th>Direccion</th>
					<th>Telefono</th>
				</thead>
				<c:forEach items="${listaContactos}" var="contacto">
					<tr>
		
						<td><input type="radio" name="selectContacto"  onclick="cambiarIdABorrar('${contacto.getNombre()}${contacto.getApellido1()}${contacto.getApellido2()}')"></td>

						<td>${contacto.getNombre()}</td>
						<td>${contacto.getApellido1()}</td>
						<td>${contacto.getApellido2()}</td>
						<td>${contacto.getDireccion()}</td>
						<td>${contacto.getTelefono()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>
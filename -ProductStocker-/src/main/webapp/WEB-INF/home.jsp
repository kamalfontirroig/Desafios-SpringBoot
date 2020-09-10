<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<title>ProductStock</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script type="text/javascript">
        var id = -1;
        var index = -1;
              
        function changeId(newId, newIndex) {
            id = newId;
            index = newIndex;
  
        }
  
        function eliminarProducto() {
            if (index === -1 || id === -1) {
                alert("Debe elegir un producto para eliminarlo");
                return;
            }
            window.location.href = "/borrar?id=" + id;
        }

        function modificarProducto() {
            if (index === -1 || id === -1) {
                alert("Debe elegir un producto para modificarlo");
                return;
            }
            window.location.href = "/modificarForm?id=" + id;
        }
        
        function registrarProducto() {

             window.location.href = "/addForm"; 
        }
        
//  
    </script>
</head>


<body style="padding-top: 100px; text-align: center;">
	<form action="/buscar" class="d-inline-block col-10">
		<div class="form-group">

			<h1>-ProductStock-</h1>
			<div class="container-fluid">
			<input type="text" required class="form-control"
				name="textoBuscado" id="" aria-describedby="helpId"
				value="${textoBuscado}">

			<!-- hidden para paginacion -->
				<label for="registros" > Entradas por
				pagina </label> 
		<input type="number" id="registros" class="d-inline-block col-2"
				value="${(cantidadPorPagina==null)?10:cantidadPorPagina }"
				placeholer="Cantidad de registros" min="1" max="100"
				name="cantidadPorPagina" required> 
				</div>
				<input hidden id="pagina"
				name="pagina" type="number" value="${(paginaM==null)?0:paginaM}">
			<small id="helpId" class="form-text text-muted text-left"> <c:if
					test="${error != null}">


					<span style="color: red;"> <c:out value="${error}"></c:out>
					</span>
				</c:if> <span style="color: blue;"> <c:if test="${mensaje != null}">${mensaje}</c:if>
			</span> <c:if test="${listaProductos == null}">Busque por nombre de producto</c:if>
			</small>
	
		<div style="text-align: left;" class="my-2">
			<button type="submit" class="btn btn-success d-inline-block">Buscar</button>
	</form>
	<input type="button" class="btn btn-primary d-inline-block"
		value="Nuevo Producto" onclick="registrarProducto()">
	</button>
	<input type="button" class="btn btn-primary d-inline-block"
		value="Modificar" onclick="modificarProducto()">
	</button>
	<input type="button" class="btn btn-primary d-inline-block"
		value="Eliminar" onclick="eliminarProducto()">
	</button>

	</div>
	</div>

	<!-- MOSTRAR LISTA DE PRODUCTOS (if available) -->
	<c:if test="${listaProductos != null }">

		<!-- link a paginas -->
		<ul class="list-inline">
			<c:forEach var="i" begin="1" end="${paginas}">
				<li class="list-inline-item">|
					<c:if test="${pagina == i - 1}">
						<a href="" class="btn disabled">${i}</a>
					</c:if> 
					<c:if test="${pagina != i - 1 }">
						<a href="/buscar?textoBuscado=${textoBuscado}&cantidadPorPagina=${cantidadPorPagina}&pagina=${i - 1}" class="btn" style="color: blue;">${i}</a>
					</c:if>
				</li>
			</c:forEach>|
		</ul>
		<!-- end -->

		<div class="d-inline-block col-8">
			<fieldset>
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Stock</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listaProductos}" var="producto" varStatus="i">
							<tr>
								<td><input type="radio" name="productos" id=""
									onclick="changeId(${producto.getCodigo()}, ${i.index})"
									value="checkedValue"></td>
								<td>${producto.getNombre()}</td>
								<td>${producto.getPrecio()}</td>
								<td>${producto.getStock()}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</fieldset>
		</div>
	<a href="#">Go up</a>
	</c:if>

	<!-- ACTUALIZAR BOOK (if activated) -->
	<c:if test="${modoActualizar != null}">
		<div class="container">
			<form:form class="my-5" action="/modificar" method="get"
				modelAttribute="Producto">

				<fieldset class="form-group row">
					<legend class="col-form-legend col-sm-1-12">Actualizar el
						producto '${producto.getNombre()}' </legend>
					<div class="col-sm-1-12">
						<input type="number" required placeholder="" name="codigo"
							value="${producto.getCodigo()}" hidden id=""> <input
							type="text" required placeholder="Nombre" name="nombre" id=""
							value="${producto.getNombre()}"> <input type="number"
							min="0" required placeholder="Precio" name="precio" id=""
							value="${producto.getPrecio()}" required> <input
							type="number" required placeholder="Stock" name="stock" id=""
							min="0" value="${producto.getStock()}" required>

					</div>
					<div class="form-group row text-right">
						<div class="offset-sm-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Modificar</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>

	</c:if>
	<!-- REGISTRAR PRODUCTO (if activated)s -->
	<c:if test="${modoRegistrar != null}">
		<div class="container">
			<form:form class="my-5" action="/add" method="post"
				modelAttribute="Producto">

				<fieldset class="form-group row">
					<legend class="col-form-legend col-sm-1-12">Agregar
						Producto </legend>
					<div class="col-sm-1-12">
						<input type="text" required placeholder="Nombre" name="nombre"
							id=""> <input type="number" required placeholder="Precio"
							name="precio" id=""> <input type="number" required
							placeholder="Stock" name="stock" id="">
					</div>
					<div class="form-group row text-right">
						<div class="offset-sm-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Agregar</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>

	</c:if>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>
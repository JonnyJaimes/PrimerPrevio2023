 page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Paciente UFPS</title>
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">Gestión pacientes</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Pacientes </a></li>
			</ul>
		</nav>
	</header>

	<br>

	<div class="container col-md-5">

		<div class="card">

			<div class="card-body">

				<c:if test="${paciente != null}">
					<form action="update" method="get">
				</c:if>

				<c:if test="${paciente == null}">
					<form action="insert" method="get">
				</c:if>

				<caption>
					<h2>
						<c:if test="${paciente != null}">Editar </c:if>
						<c:if test="${paciente == null}">Agregar </c:if>
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>ID</label> <input type="text"
						value="<c:out value='${paciene.id}'/>" class="form-control"
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Documento</label> <input type="text"
						value="<c:out value='${pacienet.documento}'/>"
						class="form-control" name="documento" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre</label> <input type="text"
						value="<c:out value='${paciente.nombre}'/>" class="form-control"
						name="nombre" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.apellido}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.email}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.genero}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
				
					<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.fechanacimiento}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.telefono}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.direccion}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.peso}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Apellido</label> <input type="text"
						value="<c:out value='${paciente.estatura}'/>"
						class="form-control" name="apellido" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Paciente</label> <select class="form-select" name="eleccion">
						<option selected>Seleccione Una</option>
						<c:forEach var="dd" items="${listPaciente}">
							<option value='${dd.id}'>"${dd.nombre}"</option>
						</c:forEach>
					</select>
				</fieldset>

				

				<button type="submit" class="btn btn-success">Enviar</button>

				</form>

			</div>

		</div>

	</div>

</body>
</html>
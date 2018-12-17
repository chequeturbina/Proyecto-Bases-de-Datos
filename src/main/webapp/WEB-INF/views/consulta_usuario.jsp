<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Usuario</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
		<div class="row">
			<div class="col-sm-6 offset-sm-1">
				<h1 class="dashboard-heading">Usuario</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-10 offset-sm-1">
				<div>
					<table class="table table-responsive-sm table-bordered table-hover table-dark table-sm">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Paterno</th>
								<th>Materno</th>
								<th>Fotografia</th>
								<th>Celular</th>
								<th>Casa</th>
								<th>Correo</th>
								<th>Fecha Registro</th>
								<th >Direccion</th>
								<th>Tipo</th>
								<th>Instituto</th>
								<th>Hora Ingreso</th>
								<th>Hora Salida</th>
								<th>Contador Usuario</th>
							</tr>
						</thead>
						<c:forEach var="usuario" items="${usuarios}">
							<tbody>
								<tr>
									<td><span>${usuario.nombre}</span></td>
									<td><span>${usuario.paterno}</span></td>
									<td><span>${usuario.materno}</span></td>
									<td><span>${usuario.fotografia}</span></td>
									<td><span>${usuario.celular}</span></td>
									<td><span>${usuario.casa}</span></td>
									<td><span>${usuario.correo}</span></td>
									<td><span>${usuario.fRegistro}</span></td>
									<td><span>${usuario.ID_DIRECCION.calle} ${usuario.ID_DIRECCION.colonia} ${usuario.ID_DIRECCION.municipio} ${usuario.ID_DIRECCION.estado} ${usuario.ID_DIRECCION.ciudad} ${usuario.ID_DIRECCION.cp} ${usuario.ID_DIRECCION.interior} ${usuario.ID_DIRECCION.exterior}</span></td>
									<td><span>${usuario.ID_TIPO.tipo}</span></td>
									<td><span>${usuario.instituto}</span></td>
									<td><span>${usuario.hora_ingreso}</span></td>
									<td><span>${usuario.hora_salida}</span></td>
									<td><span>${usuario.contadorusuario}</span></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Vehiculo</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="col-sm-6 offset-sm-1">
			<h1 class="dashboard-heading">Vehiculos</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-10 offset-sm-1">
			<div>
				<table class="table table-responsive-sm table-bordered table-hover table-dark table-sm">
					<thead>
						<tr>
							<th>Marca</th>
							<th>Año</th>
							<th>Pasajeros</th>
							<th>Capacidad</th>
							<th>Seguro</th>
							<th>Tipo de Seguro</th>
							<th>Chofer</th>
							<th>Puertas</th>
							<th>Refaccion</th>
							<th>Tipo de Carro</th>
							<th>Tipo de Gas</th>
							<th>Cilindros</th>
							<th>Dueño</th>
						</tr>
					</thead>
					<c:forEach var="vehiculo" items="${vehiculos}">
						<tbody>
							<tr>
								<td><span>${vehiculo.marca}</span></td>
								<td><span>${vehiculo.anio}</span></td>
								<td><span>${vehiculo.pasajeros}</span></td>
								<td><span>${vehiculo.capacidad}</span></td>
								<td><span>${vehiculo.seguro}</span></td>
								<td><span>${vehiculo.tipo_seguro}</span></td>
								<td><span>${vehiculo.ID_CHOFER.nombre}</span></td>
								<td><span>${vehiculo.ID_PUERTAS.puertas}</span></td>
								<td><span>${vehiculo.ID_REFACCION.refaccion}</span></td>
								<td><span>${vehiculo.ID_TIPOCARRO.tipocarro}</span></td>
								<td><span>${vehiculo.ID_TIPOGAS.tipogas}</span></td>
								<td><span>${vehiculo.ID_CILINDROS.cilindros}</span></td>
								<td><span>${vehiculo.RFC.rfc}</span></td>
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
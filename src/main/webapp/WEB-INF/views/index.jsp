<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="/js/back.js"></script>
    
    <title>Bases de Datos</title>
  
  </head>
  
  <body onload="nobackbutton();">
    
    <div class="row">
    	<div class="col-sm-6 offset-sm-2">
    		<br/>
    		<h1>BASES DE DATOS</h1>
    		<br/>
    	</div>
    </div>
    <div class="cotainer">
        <div class="row">
            <div class="col-sm-2 offset-sm-2">
                    <div class="card">
                        <div class="card-header">REGISTRO</div>
                        <div class="card-body">
                        	<button type="button" class="btn btn-primary btn-sm " onclick="window.location='/registro_chofer';">REGISTRAR CHOFER</button>
                        	<br></br>
							<button type="button" class="btn btn-primary btn-sm" onclick="window.location='/registro_duenio';">REGISTRAR DUEÑO</button>
							<br></br>
							<button type="button" class="btn btn-primary btn-sm" onclick="window.location='/registro_vehiculo';">REGISTRAR VEHICULO</button>
							<br></br>
							<button type="button" class="btn btn-primary btn-sm" onclick="window.location='/registro_usuario';">REGISTRAR USUARIO</button>
                        </div>
                    </div>
            </div>
            <div class="col-sm-2 offset-sm-1">
                    <div class="card">
                        <div class="card-header">CONSULTAS</div>
                        <div class="card-body">
                        	<button type="button" class="btn btn-success btn-sm" onclick="window.location='/consulta_chofer';">CHOFERES</button>
                        	<br></br>
							<button type="button" class="btn btn-success btn-sm" onclick="window.location='/consulta_duenio';">DUEÑOS</button>
							<br></br>
							<button type="button" class="btn btn-success btn-sm" onclick="window.location='/consulta_vehiculo';">VEHICULOS</button>
							<br></br>
							<button type="button" class="btn btn-success btn-sm" onclick="window.location='/consulta_usuario';">USUARIOS</button>
							<br></br>
							<button type="button" class="btn btn-success" onclick="window.location='/consulta_multa';">MULTAS</button>
                        </div>
                    </div>
    </div>
            <div class="col-sm-2 offset-sm-1">
                    <div class="card">
                        <div class="card-header">VIAJES</div>
                        <div class="card-body">
							<button type="button" class="btn btn-warning btn-sm" onclick="window.location='/viaje_solo';">VIAJE SOLO</button>
							<br></br>
							<button type="button" class="btn btn-warning btn-sm" onclick="window.location='/viaje_compartido';">VIAJE COMPARTIDO</button>
							<br></br>
							<button type="button" class="btn btn-warning btn-sm" onclick="window.location='/viaje_chofer';">VIAJE CHOFER</button>
							<br></br>
                        </div>
                    </div>
            </div>
            </div>
            </div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
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

    <title>Bases de Datos</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <script src="/js/back.js"></script>
    
    
  </head>
  
  
  <body onload="nobackbutton();">
   <nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
    <div class="container">
    <a class="navbar-brand" href="<c:url value="/"/>">BASES DE DATOS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    
    </div>
</nav>

<c:if test="${success != null}">
			<div class="alert alert-success">${success}</div>
		</c:if>
		<c:if test="${warning != null}">
			<div class="alert alert-danger">${warning}</div>
		</c:if>
<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Registrar Vehiculo</div>
                        <div class="card-body">
                            <form name="my-form" method="POST" action="/registro/vehiculo">
                           
                            <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Dueño</label>
                                    <div class="col-md-6">
                                        <input type="text" id="rfc" class="form-control" name="rfc" placeholder="RFC DEL DUEÑO" required>
                                    </div>
                                </div>
                                
                                 <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Chofer Asignado</label>
                                    <div class="col-md-6">
                                        <input type="text" id="licencia" class="form-control" name="licencia" placeholder="NO. LICENCIA DEL CHOFER A ASIGNAR" required>
                                    </div>
                                </div>
                           
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Modelo</label>
                                    <div class="col-md-6">
                                        <input type="text" id="modelo" class="form-control" name="modelo" placeholder="MODELO" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Marca</label>
                                    <div class="col-md-6">
                                        <input type="text" id="Marca" class="form-control" name="marca" placeholder="MARCA" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Año</label>
                                    <div class="col-md-6">
                                        <input type="text" id="number" class="form-control" maxlength="4" name="anio" placeholder="AÑO" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">Capacidad lts.</label>
                                    <div class="col-md-6">
                                        <input type="text" id="number" class="form-control" name="capacidad" maxlength="10" placeholder="CAPACIDAD TANQUE DE GAS" required>
                                    </div>
                                </div>
                                
                                 <div class="form-group row">
                                 <label for="full_name" class="col-md-4 col-form-label text-md-right">Numero de Puertas</label>
						<div class="dropdown">
							<select name="npuertas" class="form-control"
								id="exampleFormControlSelect1">
								<c:forEach var="puercas" items="${portas}">
									<option value="${puercas.ID_PUERTAS}">${puercas.puertas}</option>
								</c:forEach>
							</select>
						</div>
                                 </div>
                                
                                <div class="form-group row">
						<label for="full_name" class="col-md-4 col-form-label text-md-right">Cilindros</label>
						<div class="dropdown">
							<select name="cilindros" class="form-control"
								id="exampleFormControlSelect1">
								<c:forEach var="cilin" items="${cilindreros}">
									<option value="${cilin.ID_CILINDROS}">${cilin.cilindros}</option>
								</c:forEach>
							</select>
						</div>
						
						<label for="full_name" class="col-md-4 col-form-label text-md-right">Llanta de Refaccion</label>
						<div class="dropdown">
							<select name="refaccion" class="form-control"
								id="exampleFormControlSelect1">
								<c:forEach var="refac" items="${refacciones}">
									<option value="${refac.ID_REFACCION}">${refac.refaccion}</option>
								</c:forEach>
							</select>
						</div>			
					</div>
                            
                            <div class="form-group row">
						<label for="full_name" class="col-md-4 col-form-label text-md-right">Tipo de Carro</label>
						<div class="dropdown">
							<select name="tipocarro" class="form-control"
								id="exampleFormControlSelect1">
								<c:forEach var="tipocarrin" items="${tipejos}">
									<option value="${tipocarrin.ID_TIPOCARRO}">${tipocarrin.tipocarro}</option>
								</c:forEach>
							</select>
						</div>
						
						</div>
						
						<div class="form-group row">
						<label for="full_name" class="col-md-4 col-form-label text-md-right">Tipo de Gasolina</label>
						<div class="dropdown">
							<select name="tipogas" class="form-control"
								id="exampleFormControlSelect1">
								<c:forEach var="gaso" items="${gasolinari}">
									<option value="${gaso.ID_TIPOGAS}">${gaso.tipogas}</option>
								</c:forEach>
							</select>
						</div>
						</div>
                            
                            <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Seguro</label>
                                    <div class="col-md-6">
                                        <input type="text" id="seguro" class="form-control" name="seguro" placeholder="NOMBRE DEL SEGURO">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Cobertura</label>
                                    <div class="col-md-6">
                                        <input type="text" id="cobertura" class="form-control" name="cobertura" placeholder="COBERTURA DEL SEGURO">
                                    </div>
                                </div>
                            
                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-block btn-primary">
                                        Registrar
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>

</main>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		
	<script src="/js/custom.js"></script>
	
	<script type="text/javascript">
	$('input[id="number"]').keyup(function(e)
            {
if (/\D/g.test(this.value))
{
// Filter non-digits from input value.
this.value = this.value.replace(/\D/g, '');
}
});
	</script>
	
  </body>
</html>
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
<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Registrar USUARIO</div>
                        <div class="card-body">
                            <form name="my-form" method="POST" action="/registro/usuario">
                            
                            <div class="form-group row">
						<label for="full_name" class="col-md-4 col-form-label text-md-right">Tipo Usuario</label>
						<div class="dropdown">
							<select name="tipo_usuario" class="form-control"
								id="exampleFormControlSelect1">
								<c:forEach var="tipos" items="${niveles}">
									<option value="${tipos.ID_TIPO}">${tipos.tipo}</option>
								</c:forEach>
							</select>
						</div>
					</div>
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Nombre</label>
                                    <div class="col-md-6">
                                        <input type="text" id="nombre" class="form-control" name="nombre" placeholder="NOMBRE" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Paterno</label>
                                    <div class="col-md-6">
                                        <input type="text" id="paterno" class="form-control" name="paterno" placeholder="APELLIDO PATERNO" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Materno</label>
                                    <div class="col-md-6">
                                        <input type="text" id="materno" class="form-control" name="materno" placeholder="APELLIDO MATERNO" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">Correo</label>
                                    <div class="col-md-6">
                                        <input type="email" id="correo" class="form-control" name="correo" placeholder="CORREO" required>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">Instituto</label>
                                    <div class="col-md-6">
                                        <input type="text" id="instituto" class="form-control" name="instituto" placeholder="INSTITUTO" required>
                                    </div>
                                </div>
                        
                                <div class="form-group row">
                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">Numero Celular</label>
                                    <div class="col-md-6">
                                        <input type="text" id="number" class="form-control" name="celular" maxlength="10" placeholder="NO. CELULAR" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">Numero Casa</label>
                                    <div class="col-md-6">
                                        <input type="text" id="number" class="form-control" name="casa" maxlength="8" placeholder="NO. CASA">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Hora Entrada</label>
                                    <div class="col-md-6">
                                    <input type="time" id="entrada" name="entrada" min="00:00" max="24:00">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Hora Salida</label>
                                    <div class="col-md-6">
                                    <input type="time" id="salida" name="salida" min="00:00" max="24:00">
                                    </div>
                                </div>
                                
                                <div class="card-header">DIRECCION</div>
                                
                                <div class="card-body">
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Calle</label>
                                    <div class="col-md-6">
                                        <input type="text" id="calle" name="calle" class="form-control" placeholder="CALLE" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Colonia</label>
                                    <div class="col-md-6">
                                        <input type="text" id="colonia" name="colonia" class="form-control" placeholder="COLONIA" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Municipio/Delegacion</label>
                                    <div class="col-md-6">
                                        <input type="text" id="municipio" name="municipio" class="form-control" placeholder="MUNICIPIO O DELEGACION" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Estado</label>
                                    <div class="col-md-6">
                                        <input type="text" id="estado" name="estado" class="form-control" placeholder="ESTADO" required>
                                    </div>
                                </div>
                                
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Codigo Postal</label>
                                    <div class="col-md-6">
                                        <input type="number" id="number" name="cp" class="form-control" placeholder="CP" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Num. Exterior</label>
                                    <div class="col-md-6">
                                        <input type="number" id="number" name="exterior" class="form-control" placeholder="EXTERIOR" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-4 col-form-label text-md-right">Num. Interior</label>
                                    <div class="col-md-6">
                                        <input type="number" id="number" name="interior" class="form-control" placeholder="INTERIOR">
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
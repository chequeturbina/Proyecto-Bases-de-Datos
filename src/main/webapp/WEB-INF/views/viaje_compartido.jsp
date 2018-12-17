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
<c:if test="${error != null}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
<main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Formulario COMPARTIDO</div>
                        <div class="card-body">
                            <form name="my-form" method="POST" action="/pedir/viaje_compartido">
                            
                            
                            <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Email</label>
                                    <div class="col-md-6">
                                        <input type="email" id="correo" class="form-control" name="correo" placeholder="EMAIL DEL USUARIO" required>
                                    </div>
                                </div>
                            
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Distancia Km.</label>
                                    <div class="col-md-6">
                                        <input type="number" id="distancia" class="form-control" name="distancia" placeholder="DISTANCIA KM." required>
                                        
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Tiempo Min.</label>
                                    <div class="col-md-6">
                                        <input type="number" id="tiempo" class="form-control" name="tiempo" placeholder="TIEMPO MINUTOS" required>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                 <label for="full_name" class="col-md-4 col-form-label text-md-right">Origen dentro de CU?</label>
						<div class="dropdown">
							<select name="origen" class="form-control"
								id="destinopregunta2">
								<c:forEach var="origen" items="${origen}">
									<option value="${origen.ID_ORIGEN}">${origen.origen}</option>
								</c:forEach>
							</select>
						</div>
						
                                <div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">Origen</label>
                                    <div class="col-md-6">
                                        <input type="text" id="origin" class="form-control" name="origin" placeholder="ORIGEN" required>
                                    </div>
                                </div>
                                </div>
                                
                                <div class="form-group row">
                                 <label for="full_name" class="col-md-4 col-form-label text-md-right">DESTINO dentro de CU?</label>
						<div class="dropdown">
							<select name="destino" class="form-control"
								id="destinopregunta">
								<c:forEach var="destino" items="${destino}">
									<option value="${destino.ID_DESTINO}">${destino.destino}</option>
								</c:forEach>
							</select>
						</div>
                                <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">Destino</label>
                                    <div class="col-md-6">
                                        <input type="text" id="destiny" class="form-control" name="destiny" placeholder="DESTINO" required>
                                    </div>
                                </div>
                                </div>
                        
                                
                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-block btn-primary">
                                        Pedir Viaje
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
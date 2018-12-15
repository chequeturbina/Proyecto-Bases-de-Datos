<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>
  <html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-token" content="{{ csrf_token() }}">
    <title>Chofer</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <meta name="theme-color" content="black">
<style>
.with-nav-tabs.panel-primary .nav-tabs > li > a,
.with-nav-tabs.panel-primary .nav-tabs > li > a:hover,
.with-nav-tabs.panel-primary .nav-tabs > li > a:focus {
  color: #fff;
}
.with-nav-tabs.panel-primary .nav-tabs > .open > a,
.with-nav-tabs.panel-primary .nav-tabs > .open > a:hover,
.with-nav-tabs.panel-primary .nav-tabs > .open > a:focus,
.with-nav-tabs.panel-primary .nav-tabs > li > a:hover,
.with-nav-tabs.panel-primary .nav-tabs > li > a:focus {
  color: #fff;
  background-color: blue;
  border-color: transparent;
}
.with-nav-tabs.panel-primary .nav-tabs > li.active > a,
.with-nav-tabs.panel-primary .nav-tabs > li.active > a:hover,
.with-nav-tabs.panel-primary .nav-tabs > li.active > a:focus {
  color: gray;
  background-color: #fff;
  border-color: gray;
  border-bottom-color: transparent;
}
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu {
  background-color: gray;
  border-color: gray;
}
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > li > a {
  color: #fff;   
}
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > li > a:hover,
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > li > a:focus {
  background-color: gray;
}
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > .active > a,
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > .active > a:hover,
.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > .active > a:focus {
  background-color: gray;
}
</style>
</head>
<body>

  <script type="text/javascript">
    $(document).ready(function () {


      $('.nav-tabs a, .js-nav-tabs a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
      })


      var trigger = $('.hamburger, .overlay, #sidebar-wrapper a'),
      overlay = $('.overlay'),
      isClosed = false;

      trigger.click(function () {
        hamburger_cross();
      });

      function hamburger_cross() {

        if (isClosed == true) {
          overlay.hide();
          $('.hamburger').removeClass('is-open');
          $('.hamburger').addClass('is-closed');
          isClosed = false;
        } else {
          overlay.show();
          $('.hamburger').removeClass('is-closed');
          $('.hamburger').addClass('is-open');
          isClosed = true;
        }
      }

      $('[data-toggle="offcanvas"], .overlay, #sidebar-wrapper a').click(function () {
        $('#wrapper').toggleClass('toggled');
      });

      $('a[href*="#"]:not([href="#"])').click(function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
          var target = $(this.hash);
          target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
          if (target.length) {
            $('html, body').animate({
              scrollTop: target.offset().top
            }, 1000);
            return false;
          }
        }
      });

      var scroll = $(document).scrollTop();
      var header = $('.app-header-wrap');
      var hamburger = $('.hamburger');
      var headerHeight = header.outerHeight();

      $(window).scroll(function() {
        var scrolled = $(document).scrollTop();
        if (scrolled > headerHeight){
          header.addClass('off-canvas');
          hamburger.addClass('filled');
        } else {
          header.removeClass('off-canvas');
          hamburger.removeClass('filled');
        }

        if (scrolled > scroll){
          header.removeClass('fixed');
        } else {
          header.addClass('fixed');
        }
        scroll = $(document).scrollTop();
      });
    });
  </script>
	<!-- /.navbar -->
	<!-- /container -->
	<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h1 class="dashboard-heading">
                Vehiculo
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="panel with-nav-tabs panel-primary">
                <div class="panel-heading">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab1primary" data-toggle="tab">Todos los Vehiculos</a></li>
                        <li><a href="#tab2primary" data-toggle="tab">consulta2</a></li>
                        <li><a href="#tab3primary" data-toggle="tab">consulta3</a></li>
                    </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
                            <div class="table-responsive">
                                <table class="table table-striped big-tableCenter big-table">
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
                                        <c:forEach var="chofer" items="${choferes}">
                                        <c:if test="${vehiculo.ID_CHOFER==chofer}">
                                        <td><span>${chofer.nombre}</span></td>
                                        </c:if>
                                        </c:forEach>
                                        <c:forEach var="puerta" items="${puertas}">
                                        <c:if test="${vehiculo.ID_PUERTAS==puerta}">
                                        <td><span>${puerta.puertas}</span></td>
                                        </c:if>
                                        </c:forEach>
                                        <c:forEach var="refaccion" items="${refacciones}">
                                        <c:if test="${vehiculo.ID_REFACCION==refaccion}">
                                        <td><span>${refaccion.refaccion}</span></td>
                                        </c:if>
                                        </c:forEach>
                                        <c:forEach var="tipocarro" items="${tiposcarro}">
                                        <c:if test="${vehiculo.ID_TIPOCARRO==tipocarro}">
                                        <td><span>${tipocarro.tipocarro}</span></td>
                                        </c:if>
                                        </c:forEach>
                                        <c:forEach var="tipogas" items="${tiposgas}">
                                        <c:if test="${vehiculo.ID_TIPOGAS==tipogas}">
                                        <td><span>${tipogas.tipogas}</span></td>
                                        </c:if>
                                        </c:forEach>
                                        <c:forEach var="cilindro" items="${cilindros}">
                                        <c:if test="${vehiculo.ID_CILINDROS==cilindro}">
                                        <td><span>${cilindro.cilindros}</span></td>
                                        </c:if>
                                        </c:forEach>
                                        <c:forEach var="duenio" items="${duenios}">
                                        <c:if test="${vehiculo.RFC==duenio}">
                                        <td><span>${duenio.rfc}</span></td>
                                        </c:if>
                                        </c:forEach>
                                      </tr>
                                  </tbody>  
                                  </c:forEach>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-7">
                                    <div class="table-responsive">
                                        <table class="table table-striped big-tableCenter">
                                            <thead>
                                                <tr>
                                                    <th>tabla1</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab2primary">
                            <div class="table-responsive">
                                <table class="table table-striped big-tableCenter big-table">
                                    <thead>
                                      <tr>
                                        <th>Modelo</th>
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
                                    
                                    <tbody>  
                                      <tr>
                                        <td><span></span></td>
                                      </tr>
                                  </tbody>  
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-7">
                                    <div class="table-responsive">
                                        <table class="table table-striped big-tableCenter">
                                            <thead>
                                                <tr>
                                                    <th>tabla2</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab3primary">
                            <div class="table-responsive">
                                <table class="table table-striped big-tableCenter big-table">
                                    <thead>
                                      <tr>
                                        <th>Modelo</th>
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
                                    
                                    <tbody>
                                          
                                      <tr>
                                        <td><span></span></td>
                                      </tr>
                               
                                  </tbody>  
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-7">
                                    <div class="table-responsive">
                                        <table class="table table-striped big-tableCenter">
                                            <thead>
                                                <tr>
                                                    <th>tabla3</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


package com.brabbit.springboot.app.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brabbit.springboot.app.models.entity.Chofer;
import com.brabbit.springboot.app.models.entity.Cilindros;
import com.brabbit.springboot.app.models.entity.Destino;
import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.Duenio;
import com.brabbit.springboot.app.models.entity.LlantaRefaccion;
import com.brabbit.springboot.app.models.entity.NPuertas;
import com.brabbit.springboot.app.models.entity.Origen;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.service.ChoferDaoImplement;
import com.brabbit.springboot.app.models.service.CilindrosDaoImplement;
import com.brabbit.springboot.app.models.service.DestinoDaoImplement;
import com.brabbit.springboot.app.models.service.DireccionDaoImplement;
import com.brabbit.springboot.app.models.service.DuenioDaoImplement;
import com.brabbit.springboot.app.models.service.InterfaceUsuarioDao;
import com.brabbit.springboot.app.models.service.LlantaRefaccionDaoImplement;
import com.brabbit.springboot.app.models.service.NPuertasDaoImplement;
import com.brabbit.springboot.app.models.service.OrigenDaoImplement;
import com.brabbit.springboot.app.models.service.TipoCarroDaoImplement;
import com.brabbit.springboot.app.models.service.TipoGasDaoImplement;
import com.brabbit.springboot.app.models.service.TipoUsuarioDaoImplement;
import com.brabbit.springboot.app.models.service.UsuarioDaoImplement;
import com.brabbit.springboot.app.models.service.VehiculoDaoImplement;
import com.brabbit.springboot.app.models.service.ViajeDaoImplement;
import com.brabbit.springboot.app.models.entity.TipoUsuario;
import com.brabbit.springboot.app.models.entity.Usuario;
import com.brabbit.springboot.app.models.entity.Vehiculo;
import com.brabbit.springboot.app.models.entity.Viaje;
import com.brabbit.springboot.app.models.entity.Origen;
import com.brabbit.springboot.app.models.entity.Destino;
import com.brabbit.springboot.app.models.service.OrigenDaoImplement;
import com.brabbit.springboot.app.models.service.DestinoDaoImplement;
import com.brabbit.springboot.app.models.service.ViajeDaoImplement;

//AQUI SE DEFINIRAN LAS RUTAS HACIA LAS VISTAS.
@Controller

public class RutasController {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	
	@Autowired
	private TipoUsuarioDaoImplement tipoDao;
	
	@Autowired
	private CilindrosDaoImplement cilindrosDao;
	
	@Autowired
	private LlantaRefaccionDaoImplement refaccionDao;
	
	@Autowired
	private TipoCarroDaoImplement tipoCarroDao;
	
	@Autowired
	private NPuertasDaoImplement puertasDao;
	
	@Autowired
	private TipoGasDaoImplement tipoGasDao;
	
	@Autowired
	private DireccionDaoImplement direccionDao;
	
	@Autowired
	private UsuarioDaoImplement usuarioDao;
	
	@Autowired
	private OrigenDaoImplement origenDao;
	
	@Autowired
	private DestinoDaoImplement destinoDao;
	
	@Autowired
	private ViajeDaoImplement viajeDao;
	
	@Autowired
	private ChoferDaoImplement choferDao;
	
	@Autowired
	private DuenioDaoImplement duenioDao;
	
	@Autowired
	private VehiculoDaoImplement vehiculoDao;
	
	/*-------------------------------------VISTAS-------------------------------------*/
	@GetMapping("/")
	public String inicio(Model model) {
		
		return "index";
	}
	
	@GetMapping("/registro_duenio")
	public String RegistroDuenio(Model model) {
		return "registro_dueño";
	}
	
	@GetMapping("/registro_usuario")
	public String RegistroUsuario(Model model) {
		List<TipoUsuario> um = tipoDao.findAll();
		model.addAttribute("niveles", um);
		return "registro_usuario";
	}
	
	@GetMapping("/registro_chofer")
	public String RegistroChofer(Model model) {
		return "registro_chofer";
	}
	
	@GetMapping("/registro_vehiculo")
	public String RegistroVehiculo(Model model) {
		List<Cilindros> um = cilindrosDao.findAll();
		model.addAttribute("cilindreros", um);
		
		List<LlantaRefaccion> am = refaccionDao.findAll();
		model.addAttribute("refacciones", am);
		
		List<TipoCarro> em = tipoCarroDao.findAll();
		model.addAttribute("tipejos", em);
		
		List<TipoGas> im = tipoGasDao.findAll();
		model.addAttribute("gasolinari", im);
		
		List<NPuertas> om = puertasDao.findAll();
		model.addAttribute("portas", om);
		
		return "registro_vehiculo";
	}
	
	@GetMapping("/viaje_solo")
	public String Viaje(Model model) {
		List<Origen> am = origenDao.findAll();
		model.addAttribute("origen", am);
		List<Destino> em = destinoDao.findAll();
		model.addAttribute("destino", em);
		return "viaje_solo";
	}
	
	@GetMapping("/viaje_chofer")
	public String ViajeChofer(Model model) {
		
		List<Viaje> Viajes = viajeDao.listarViajes();
		model.addAttribute("viajes", Viajes);
		
		return "viaje_chofer";
	}
	
	@GetMapping("/viaje_exitoso")
	public String VaijeExitoso(Model model) {
		return "viajeExitoso";
	}
	
	/*-------------------------------------REGISTROS-------------------------------------*/
	
	@RequestMapping(value="registro/usuario", method = RequestMethod.POST)
	public String RegistrarUsuario(@RequestParam("tipo_usuario") long tipo,
			                @RequestParam("nombre")  String nombre,
			                @RequestParam("paterno") String paterno,
			                @RequestParam("materno") String materno,
			                @RequestParam("correo")  String correo,
			                @RequestParam("instituto")  String instituto,
			                @RequestParam("celular") String celular,
			                @RequestParam("casa")    String casa,
			                @RequestParam("entrada") String entrada,
			                @RequestParam("salida")  String salida,
			                @RequestParam("calle")   String calle,
			                @RequestParam("colonia") String colonia,
			                @RequestParam("municipio") String municipio,
			                @RequestParam("estado")    String estado,
			                @RequestParam("cp")       String cp,
			                @RequestParam("exterior") String exterior,
			                @RequestParam("interior") String interior,
			                RedirectAttributes ra) {
		
		
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setColonia(colonia);
		direccion.setMunicipio(municipio);
		direccion.setEstado(estado);
		direccion.setCp(Integer.parseInt(cp));
		direccion.setExterior(Integer.parseInt(exterior));
		direccion.setInterior(interior);
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setPaterno(paterno);
		usuario.setMaterno(materno);
		usuario.setCorreo(correo);
		
		TipoUsuario tipUsuario = tipoDao.findOne(tipo);
		usuario.setID_TIPO(tipUsuario);
		
		usuario.setInstituto(instituto);
		usuario.setCelular(celular);
		usuario.setCasa(casa);
		usuario.setHora_ingreso(entrada);
		usuario.setHora_salida(salida);
		usuario.setID_DIRECCION(direccion);
		
		Date now = new Date();
        usuario.setfRegistro(now);
		
		usuarioDao.save(usuario);
	
		ra.addFlashAttribute("success", "Exito al Registrar");
		
		return"redirect:/registro_usuario";
		
	}
	
	@RequestMapping(value="registro/chofer", method = RequestMethod.POST)
	public String RegistrarChofer(@RequestParam("nombre")  String nombre,
			                @RequestParam("paterno") String paterno,
			                @RequestParam("materno") String materno,
			                @RequestParam("correo")  String correo,
			                @RequestParam("licencia")  String licencia,
			                @RequestParam("celular") String celular,
			                
			                @RequestParam("calle")   String calle,
			                @RequestParam("colonia") String colonia,
			                @RequestParam("municipio") String municipio,
			                @RequestParam("estado")    String estado,
			                @RequestParam("cp")       String cp,
			                @RequestParam("exterior") String exterior,
			                @RequestParam("interior") String interior,
			                RedirectAttributes ra) {
		
		
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setColonia(colonia);
		direccion.setMunicipio(municipio);
		direccion.setEstado(estado);
		direccion.setCp(Integer.parseInt(cp));
		direccion.setExterior(Integer.parseInt(exterior));
		direccion.setInterior(interior);
		
		Chofer chofer = new Chofer();
		
		chofer.setNombre(nombre);
		chofer.setPaterno(paterno);
		chofer.setMaterno(materno);
		chofer.setCorreo(correo);
	
		chofer.setCelular(celular);
		chofer.setLicencia(licencia);
		
		chofer.setID_DIRECCION(direccion);
		
		Date now = new Date();
        chofer.setfRegistro(now);
		
		choferDao.save(chofer);
	
		ra.addFlashAttribute("success", "Exito al Registrar");
		
		return"redirect:/registro_chofer";
		
	}
	
	@RequestMapping(value="registro/duenio", method = RequestMethod.POST)
	public String RegistrarDuenio(@RequestParam("rfc")  String rfc,
			                      @RequestParam("nombre")  String nombre,
			                      @RequestParam("paterno") String paterno,
			                      @RequestParam("materno") String materno,
			                      @RequestParam("correo")  String correo,
			                      @RequestParam("licencia")  String licencia,
			                      @RequestParam("celular") String celular,
			                      @RequestParam("calle")   String calle,
			                      @RequestParam("colonia") String colonia,
			                      @RequestParam("municipio") String municipio,
			                      @RequestParam("estado")    String estado,
			                      @RequestParam("cp")       String cp,
			                      @RequestParam("exterior") String exterior,
			                      @RequestParam("interior") String interior,
			                      @RequestParam("opcion") String opcion,
			                      RedirectAttributes ra) {
		
		
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setColonia(colonia);
		direccion.setMunicipio(municipio);
		direccion.setEstado(estado);
		direccion.setCp(Integer.parseInt(cp));
		direccion.setExterior(Integer.parseInt(exterior));
		direccion.setInterior(interior);
		
		Duenio duenio = new Duenio();
		
		duenio.setRfc(rfc);
		duenio.setNombre(nombre);
		duenio.setPaterno(paterno);
		duenio.setMaterno(materno);
		duenio.setCorreo(correo);
	
		duenio.setCelular(celular);
		duenio.setLicencia(licencia);
		
		duenio.setID_DIRECCION(direccion);
		
		Date now = new Date();
        duenio.setfRegistro(now);
		
		duenioDao.save(duenio);
		
		if(opcion.equals("SI")) {
			
			Chofer chofer = new Chofer();
			chofer.setNombre(nombre);
			chofer.setPaterno(paterno);
			chofer.setMaterno(materno);
			chofer.setCorreo(correo);
		
			chofer.setCelular(celular);
			chofer.setLicencia(licencia);
			
			chofer.setID_DIRECCION(direccion);
			
	        chofer.setfRegistro(now);
			
			choferDao.save(chofer);
			
			ra.addFlashAttribute("success", "Ahora Eres Dueño y Chofer");
			
			return"redirect:/registro_duenio";
			
		} else {
	
		ra.addFlashAttribute("success", "Exito al Registrar");
		
		return"redirect:/registro_duenio";
		}
	}
	
	@RequestMapping(value="registro/vehiculo", method = RequestMethod.POST)
	public String RegistrarVehiculo(@RequestParam("modelo")  String modelo,
		 	                        @RequestParam("marca")  String marca,
		 	                       @RequestParam("matricula")  String matricula,
		 	                        @RequestParam("anio")  String anio,
		 	                        @RequestParam("capacidad")  String capacidad,
		 	                        @RequestParam("npuertas")  long npuertas,
		 	                        @RequestParam("cilindros")  long cilindros,
		 	                        @RequestParam("refaccion")  long refaccion,
		 	                        @RequestParam("tipocarro")  long tipocarro,
		 	                        @RequestParam("tipogas")  long tipogas,
		 	                        @RequestParam("seguro")  String seguro,
		 	                        @RequestParam("cobertura")  String cobertura,
		 	                        @RequestParam("rfc")  String rfc,
		 	                        @RequestParam("licencia")  String licencia,
		 	                        RedirectAttributes ra) {
		
		Duenio duenio = duenioDao.porNombre(rfc);
		Chofer chofer = choferDao.porLicencia(licencia);
		
		if(duenio != null && chofer != null) {
		
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setModelo(modelo);
		vehiculo.setMarca(marca);
		vehiculo.setMatricula(matricula);
		vehiculo.setAnio(Integer.parseInt(anio));
		vehiculo.setCapacidad(Integer.parseInt(capacidad));
		
		vehiculo.setSeguro(seguro);
		vehiculo.setTipo_seguro(cobertura);
		
		NPuertas puertas = puertasDao.findOne(npuertas);
		vehiculo.setID_PUERTAS(puertas);
		
		Cilindros cilindro = cilindrosDao.findOne(cilindros);
		vehiculo.setID_CILINDROS(cilindro);
		
		LlantaRefaccion llanta = refaccionDao.findOne(refaccion);
		vehiculo.setID_REFACCION(llanta);
		
		TipoCarro estilo = tipoCarroDao.findOne(tipocarro);
		vehiculo.setID_TIPOCARRO(estilo);
		
		TipoGas gaso = tipoGasDao.findOne(tipogas);
		vehiculo.setID_TIPOGAS(gaso);
		
		vehiculo.setRFC(duenio);
		vehiculo.setID_CHOFER(chofer);
		vehiculoDao.save(vehiculo);
	    
		ra.addFlashAttribute("success", "Exito al Registrar");
		
		return"redirect:/registro_vehiculo";
		}else {
			
			ra.addFlashAttribute("warning", "El Dueño No Existe En La Base De Datos");
			
			return"redirect:/registro_vehiculo";
			
		}
		
	}
	
	
	/*-------------------------------------CONSULTAS-------------------------------------*/
	
	@RequestMapping("/consulta_chofer")
	public String consultaChofer(Model model) {
		List<Chofer> Choferes=choferDao.listarChoferes();
		model.addAttribute("choferes",Choferes);
		List<Direccion> Direcciones=direccionDao.listarDirecciones();
		model.addAttribute("direcciones",Direcciones);
		return"consulta_chofer";
	}
	
	@RequestMapping("/consulta_duenio")
	public String consultaDuenio(Model model) {
		List<Duenio> Duenios=duenioDao.listarDuenios();
		model.addAttribute("duenios",Duenios);
		List<Direccion> Direcciones=direccionDao.listarDirecciones();
		model.addAttribute("direcciones",Direcciones);
		return"consulta_duenio";
	}
	
	@RequestMapping("/consulta_usuario")
	public String consultaUsuario(Model model) {
		List<Usuario> Usuarios=usuarioDao.listarUsuarios();
		model.addAttribute("usuarios",Usuarios);
		List<Direccion> Direcciones=direccionDao.listarDirecciones();
		model.addAttribute("direcciones",Direcciones);
		List<TipoUsuario> TiposUsuario=tipoDao.findAll();
		model.addAttribute("tipos",TiposUsuario);
		return"consulta_usuario";
	}
	
	@RequestMapping("/consulta_vehiculo")
	public String consultaVehiculo(Model model) {
		List<Vehiculo> Vehiculos=vehiculoDao.listarVehiculos();
		model.addAttribute("vehiculos",Vehiculos);
		List<Chofer> Choferes=choferDao.listarChoferes();
		model.addAttribute("choferes",Choferes);
		List<NPuertas> Puertas=puertasDao.findAll();
		model.addAttribute("puertas",Puertas);
		List<LlantaRefaccion> Refacciones=refaccionDao.findAll();
		model.addAttribute("refacciones",Refacciones);
		List<TipoCarro> Tiposcarro=tipoCarroDao.findAll();
		model.addAttribute("tiposcarro",Tiposcarro);
		List<TipoGas> TiposGas=tipoGasDao.findAll();
		model.addAttribute("tiposgas",TiposGas);
		List<Cilindros> Cilindros=cilindrosDao.findAll();
		model.addAttribute("cilindros",Cilindros);
		List<Duenio> Duenios=duenioDao.listarDuenios();
		model.addAttribute("duenios",Duenios);
		return"consulta_vehiculo";
	}
	
	@RequestMapping("/consulta_multa")
	public String consultaMulta(Model model) {
		return"consulta_multa";
	}
	
	
	/*-------------------------------------VIAJES-------------------------------------*/
	
	/*PEDIR VIAJE UNA PERSONA SOLA-------------------------PARTE DEL USUARIO*/
	
	@RequestMapping(value="/pedir/viaje", method = RequestMethod.POST)
	public String PedirViaje(@RequestParam("correo")  String correo,
		 	                 @RequestParam("distancia")  String distancia,
	 	                     @RequestParam("tiempo")  String tiempo,
	 	                     @RequestParam("pasajeros")  String pasajeros,
	 	                     @RequestParam("origen")  long origen,
	 	                     @RequestParam("origin")  String origin,
	 	                     @RequestParam("destino")  long destino,
	 	                     @RequestParam("destiny")  String destiny,
		 	                 RedirectAttributes ra) {
		
		
		/*BUSCAR USUARIO POR CORREO*/
		Usuario usuario = usuarioDao.porCorreo(correo);
	
   	    if(usuario != null) {
   	    	
             Viaje viaje = new Viaje();
             
             /*Contador para los viajes*/
     		 Integer contador = usuario.getContadorusuario() + 1;
     		 
     		/*SAber el numero de pasajeros para el primer if*/
     		Integer numpasajeros = Integer.parseInt(pasajeros);
     		viaje.setPasajeros(numpasajeros);
     		
     			if(numpasajeros == 1) {
     				
     				/*SABER EL ORIGEN Y EL DESTINO PARA SABER SI ES DENTRO DE CU O NO */
     		   	    Origen origenif = origenDao.findOne(origen);
     		   	    Destino destinoif = destinoDao.findOne(destino);
     		   	    /*String para saber si el viaje es dentro de CU o no*/
     		   	    String orin = origenif.getOrigen();
     		   	    String destn = destinoif.getDestino();
     		   	    	
     		   	    		if(orin.equals("SI") && destn.equals("SI")) {
     		   	    			
     		   	    		Integer calculodistancia = Integer.parseInt(distancia);
     		   	    		viaje.setDistancia(calculodistancia);
     		   	    		viaje.setTiempo(Integer.parseInt(tiempo));
     		   	    		viaje.setID_ORIGEN(origenif);
     		   	    		viaje.setID_DESTINO(destinoif);
     		   	    		viaje.setOrigin(origin);
     		   	    		viaje.setDestiny(destiny);
     		   	    			
     		   	    		Integer cobro = 15;
	    	  				viaje.setCobro(cobro);
	    	  				viaje.setID_USUARIO(usuario);
	    	  				viajeDao.save(viaje);
	    	  				usuarioDao.update(contador, usuario.getID_USUARIO());
	    		  	
	    	  				ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
	    	  				return"redirect:/viaje_exitoso";
     		   	    			
     		   	    		}else {
     		   	    			
     		   	    		Integer calculodistancia = Integer.parseInt(distancia);
     		   	    		viaje.setDistancia(calculodistancia);
     		   	    		viaje.setTiempo(Integer.parseInt(tiempo));
     		   	    		viaje.setID_ORIGEN(origenif);
     		   	    		viaje.setID_DESTINO(destinoif);
     		   	    		viaje.setOrigin(origin);
     		   	    		viaje.setDestiny(destiny);
     		   	    		Integer cobrofinal = 15 + (calculodistancia * 8);
	  						viaje.setCobro(cobrofinal);
	  						viaje.setID_USUARIO(usuario);
	  						viajeDao.save(viaje);
	  						usuarioDao.update(contador, usuario.getID_USUARIO());
		  	
	  						ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
	  						return"redirect:/viaje_exitoso";
     		   	    			
     		   	    		}
     				
     			}else {
     				
     				/*SABER EL ORIGEN Y EL DESTINO PARA SABER SI ES DENTRO DE CU O NO */
     		   	    Origen origenif = origenDao.findOne(origen);
     		   	    Destino destinoif = destinoDao.findOne(destino);
     		   	    /*String para saber si el viaje es dentro de CU o no*/
     		   	    String orin = origenif.getOrigen();
     		   	    String destn = destinoif.getDestino();
     		   	    
     		   	    		if(contador%5 == 1) {
     		   	    			
     		   	    			TipoUsuario tipUsuario = usuario.getID_TIPO();
     		   	    			String user = tipUsuario.getTipo();
     		   	    			System.out.println(user);
     		   	    			
     		   	    					if(orin.equals("SI") && destn.equals("SI")) {
     		   	    						
     		   	    						if(user.equals("Estudiante")) {
     		   	    							
     		   	    								Integer calculodistancia = Integer.parseInt(distancia);
     		   	    								viaje.setDistancia(calculodistancia);
     		   	    								viaje.setTiempo(Integer.parseInt(tiempo));
     		   	    								viaje.setID_ORIGEN(origenif);
     		   	    								viaje.setID_DESTINO(destinoif);
     		   	    								viaje.setOrigin(origin);
     		   	    								viaje.setDestiny(destiny);
     		   	    								Integer cobromedio = 10;
     		   	    								Integer porcentaje = 15;
     		   	    								Integer porcen = (cobromedio*porcentaje)/100;
     		   	    								Integer cobrofinal = 10 - porcen;
		        
     		   	    								viaje.setCobro(cobrofinal);
     		   	    								viaje.setID_USUARIO(usuario);
     		   	    								viajeDao.save(viaje);
     		   	    								
     		   	    								usuarioDao.update(contador, usuario.getID_USUARIO());
     						    	        	
     		   	    								ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
     		   	    								return"redirect:/viaje_exitoso";
     		   	    							
     		   	    						}else {
     		   	    							
     		   	    								Integer calculodistancia = Integer.parseInt(distancia);
     		   	    								viaje.setDistancia(calculodistancia);
     		   	    								viaje.setTiempo(Integer.parseInt(tiempo));
     		   	    								viaje.setID_ORIGEN(origenif);
     		   	    								viaje.setID_DESTINO(destinoif);
     		   	    								viaje.setOrigin(origin);
     		   	    								viaje.setDestiny(destiny);
     		   	    								Integer cobromedio = 10;
     		   	    								Integer porcentaje = 10;
     		   	    								Integer porcen = (cobromedio*porcentaje)/100;
     		   	    								Integer cobrofinal = 10 - porcen;
			        
     		   	    								viaje.setCobro(cobrofinal);
     		   	    								viaje.setID_USUARIO(usuario);
     		   	    								viajeDao.save(viaje);
    		  	
     		   	    								usuarioDao.update(contador, usuario.getID_USUARIO());
    	        	
     		   	    								ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
     		   	    								return"redirect:/viaje_exitoso";
     		   	    							
     		   	    						}
     		   	    					}else {
     		   	    						
     		   	    						if(user.equals("Estudiante")) {
     		   	    							
     		   	    								Integer calculodistancia = Integer.parseInt(distancia);
     		   	    								viaje.setDistancia(calculodistancia);
     		   	    								viaje.setTiempo(Integer.parseInt(tiempo));
     		   	    								viaje.setID_ORIGEN(origenif);
     		   	    								viaje.setID_DESTINO(destinoif);
     		   	    								viaje.setOrigin(origin);
     		   	    								viaje.setDestiny(destiny);
     		   	    								Integer cobromedio = 15 + (calculodistancia * 6);
     		   	    								Integer porcentaje = 15;
     		   	    								Integer porcen = (cobromedio*porcentaje)/100;
     		   	    								Integer cobrofinal = cobromedio - porcen;
		        
     		   	    								viaje.setCobro(cobrofinal);
     		   	    								viaje.setID_USUARIO(usuario);
     		   	    								viajeDao.save(viaje);
		  	
     		   	    								usuarioDao.update(contador, usuario.getID_USUARIO());
											
     		   	    								ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
     		   	    								return"redirect:/viaje_exitoso";
     		   	    							
     		   	    						}else {
     		   	    							
     		   	    								Integer calculodistancia = Integer.parseInt(distancia);
     		   	    								viaje.setDistancia(calculodistancia);
     		   	    								viaje.setTiempo(Integer.parseInt(tiempo));
     		   	    								viaje.setID_ORIGEN(origenif);
     		   	    								viaje.setID_DESTINO(destinoif);
     		   	    								viaje.setOrigin(origin);
     		   	    								viaje.setDestiny(destiny);
     		   	    								Integer cobromedio = 15 + (calculodistancia * 6);
     		   	    								Integer porcentaje = 10;
     		   	    								Integer porcen = (cobromedio*porcentaje)/100;
     		   	    								Integer cobrofinal = cobromedio - porcen;
		        
     		   	    								viaje.setCobro(cobrofinal);
     		   	    								viaje.setID_USUARIO(usuario);
     		   	    								viajeDao.save(viaje);
		  	
     		   	    								usuarioDao.update(contador, usuario.getID_USUARIO());
	        	
     		   	    								ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
     		   	    								return"redirect:/viaje_exitoso";
     		   	    							
     		   	    						}
     		   	    						
     		   	    					}
     		   	    			
     		   	    		}else {
     		   	    		
								TipoUsuario tipUsuario = usuario.getID_TIPO();
								String user = tipUsuario.getTipo();
								System.out.println(user);
								
								if(orin.equals("SI") && destn.equals("SI")) {
									
									if(user.equals("Estudiante")) {
										
											Integer calculodistancia = Integer.parseInt(distancia);
	   	    								viaje.setDistancia(calculodistancia);
	   	    								viaje.setTiempo(Integer.parseInt(tiempo));
	   	    								viaje.setID_ORIGEN(origenif);
	   	    								viaje.setID_DESTINO(destinoif);
	   	    								viaje.setOrigin(origin);
	   	    								viaje.setDestiny(destiny);
	   	    								Integer cobromedio = 15;
	   	    								Integer porcentaje = 15;
	   	    								Integer porcen = (cobromedio*porcentaje)/100;
	   	    								Integer cobrofinal = 15 - porcen;
    
	   	    								viaje.setCobro(cobrofinal);
	   	    								viaje.setID_USUARIO(usuario);
	   	    								viajeDao.save(viaje);
	
	   	    								usuarioDao.update(contador, usuario.getID_USUARIO());
	
	   	    								ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
	   	    								return"redirect:/viaje_exitoso";
										
									}else {
										
											Integer calculodistancia = Integer.parseInt(distancia);
											viaje.setDistancia(calculodistancia);
											viaje.setTiempo(Integer.parseInt(tiempo));
											viaje.setID_ORIGEN(origenif);
											viaje.setID_DESTINO(destinoif);
   	    									viaje.setOrigin(origin);
   	    									viaje.setDestiny(destiny);
   	    									Integer cobromedio = 15;
   	    									Integer porcentaje = 10;
   	    									Integer porcen = (cobromedio*porcentaje)/100;
   	    									Integer cobrofinal = 15 - porcen;
    
   	    									viaje.setCobro(cobrofinal);
   	    									viaje.setID_USUARIO(usuario);
   	    									viajeDao.save(viaje);
	
   	    									usuarioDao.update(contador, usuario.getID_USUARIO());
	
   	    									ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
	
   	    									return"redirect:/viaje_exitoso";
										
									}
									
								}else {
									
									if(user.equals("Estudiante")) {
										
											Integer calculodistancia = Integer.parseInt(distancia);
											viaje.setDistancia(calculodistancia);
											viaje.setTiempo(Integer.parseInt(tiempo));
											viaje.setID_ORIGEN(origenif);
											viaje.setID_DESTINO(destinoif);
	    									viaje.setOrigin(origin);
	    									viaje.setDestiny(destiny);
	    									Integer cobromedio = 15 + (calculodistancia * 8);
	    									Integer porcentaje = 15;
	    									Integer porcen = (cobromedio*porcentaje)/100;
	    									Integer cobrofinal = cobromedio - porcen;

	    									viaje.setCobro(cobrofinal);
	    									viaje.setID_USUARIO(usuario);
	    									viajeDao.save(viaje);

	    									usuarioDao.update(contador, usuario.getID_USUARIO());

	    									ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
	    									return"redirect:/viaje_exitoso";
										
									}else {
										
											Integer calculodistancia = Integer.parseInt(distancia);
											viaje.setDistancia(calculodistancia);
											viaje.setTiempo(Integer.parseInt(tiempo));
											viaje.setID_ORIGEN(origenif);
											viaje.setID_DESTINO(destinoif);
    										viaje.setOrigin(origin);
    										viaje.setDestiny(destiny);
    										Integer cobromedio = 15 + (calculodistancia * 8);
    										Integer porcentaje = 10;
    										Integer porcen = (cobromedio*porcentaje)/100;
    										Integer cobrofinal = cobromedio - porcen;

    										viaje.setCobro(cobrofinal);
    										viaje.setID_USUARIO(usuario);
    										viajeDao.save(viaje);

    										usuarioDao.update(contador, usuario.getID_USUARIO());

    										ra.addFlashAttribute("success", "Tu Viaje se realizo con exito!");
    										return"redirect:/viaje_exitoso";

										
									}
									
								}
     		   	    			
     		   	    		}
     				
     			}
     		
   	    	
   	    }else {
   	    	
   	    	ra.addFlashAttribute("error", "El Usuario No Existe En La Base De Datos");
   			
   	    	return"redirect:/viaje_solo";
   	    }
   	    }
	
	/*VIAJES PARA CHOFERES*/
	@RequestMapping(value="/viajeChofer", method = RequestMethod.POST)
	public String Viajechofer(@RequestParam("ID_VIAJE")  long ID_VIAJE,
							  @RequestParam("correo")  String correo,
							  RedirectAttributes ra) {
		
		/*BUSCAR CHOFER POR CORREO*/
		Chofer chofer = choferDao.porCorreo(correo);
		
		if(chofer != null) {
			 
    		 Viaje viaje = viajeDao.porId(ID_VIAJE);
    		 
    		 Origen origen = viaje.getID_ORIGEN();
    		 String origin = origen.getOrigen();
    		 
    		 Destino destino = viaje.getID_DESTINO();
    		 String destiny = destino.getDestino();
    		 
    		 			if(origin.equals("SI") && destiny.equals("SI")) {
    		 				
    		 					/*Contador para los viajes y chofer*/
    		 	    		 	Integer contadorchofer = chofer.getContadorchofer() + 1;
    			 
    		 					/*DAOTS DE LA GANANCIA DEL CHOFER Y EL COBRO DEL VIAJE*/
    		 					Integer ganancia = chofer.getGanancia();
    		 					Integer cobroviaje = viaje.getCobro();
    			 
    		 					Integer porcentaje = 8;
    		 					Integer porcen = (cobroviaje*porcentaje)/100;
    		 					Integer gananciafinal = ganancia + porcen;
    			 
    		 					choferDao.update(gananciafinal, chofer.getID_CHOFER());
    		 					
    		 					choferDao.updateContador(contadorchofer, chofer.getID_CHOFER());
    		 					
    		 					viaje.setID_CHOFER(chofer);
								viajeDao.save(viaje);
    			 
    		 								if(contadorchofer > 20) {
    				 
    		 										/*Contador para los viajes y chofer*/
    		 										Integer gananciabono = chofer.getGanancia();
    		 										Integer porcentajebono = 10;
    		 										Integer porcenbono = (ganancia*porcentaje)/100;
    		 										Integer bono = chofer.getBono() + porcenbono;
					 
    		 										choferDao.updateBono(bono, chofer.getID_CHOFER());
    		 										
    		 										ra.addFlashAttribute("success", "Viaje Asignado, Felicidades obtuviste tu bono de 20 viajes");
    		 							   			
    		 							   	    	return"redirect:/viaje_chofer";
    		 										
    		 								}else {
    		 									
								ra.addFlashAttribute("success", "Viaje Asignado");
		 						return"redirect:/viaje_chofer";						
    		 								}
    		 			}else {
    		 				
    		 					/*Contador para los viajes y chofer*/
		 	    		 		Integer contadorchofer = chofer.getContadorchofer() + 1;
			 
		 	    		 		/*DAOTS DE LA GANANCIA DEL CHOFER Y EL COBRO DEL VIAJE*/
		 	    		 		Integer ganancia = chofer.getGanancia();
		 	    		 		Integer cobroviaje = viaje.getCobro();
			 
		 	    		 		Integer porcentaje = 12;
		 	    		 		Integer porcen = (cobroviaje*porcentaje)/100;
		 						Integer gananciafinal = ganancia + porcen;
			 
		 						choferDao.update(gananciafinal, chofer.getID_CHOFER());
		 					
		 						choferDao.updateContador(contadorchofer, chofer.getID_CHOFER());
		 					
		 						viaje.setID_CHOFER(chofer);
		 						viajeDao.save(viaje);
			 
		 								if(contadorchofer > 20) {
				 
		 										/*Contador para los viajes y chofer*/
		 										Integer gananciabono = chofer.getGanancia();
		 										Integer porcentajebono = 10;
		 										Integer porcenbono = (ganancia*porcentaje)/100;
		 										Integer bono = chofer.getBono() + porcenbono;
				 
		 										choferDao.updateBono(bono, chofer.getID_CHOFER());
		 										
		 										ra.addFlashAttribute("success", "Viaje Asignado, Felicidades obtuviste tu bono de 20 viajes");
		 							   			
		 							   	    	return"redirect:/viaje_chofer";
		 										
		 								}else {
		 									
		 										ra.addFlashAttribute("success", "Viaje Asignado");
		 										return"redirect:/viaje_chofer";						
		 								}
    		 				
    		 			}
    		 			
			}else{
			
				ra.addFlashAttribute("error", "El Chofer No Existe En La Base De Datos");
				return"redirect:/viaje_chofer";
			}
		}	
	
}

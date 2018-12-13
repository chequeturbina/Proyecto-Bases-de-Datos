package com.brabbit.springboot.app.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brabbit.springboot.app.models.entity.Chofer;
import com.brabbit.springboot.app.models.entity.Cilindros;
import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.Duenio;
import com.brabbit.springboot.app.models.entity.LlantaRefaccion;
import com.brabbit.springboot.app.models.entity.NPuertas;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.service.ChoferDaoImplement;
import com.brabbit.springboot.app.models.service.CilindrosDaoImplement;
import com.brabbit.springboot.app.models.service.DireccionDaoImplement;
import com.brabbit.springboot.app.models.service.DuenioDaoImplement;
import com.brabbit.springboot.app.models.service.LlantaRefaccionDaoImplement;
import com.brabbit.springboot.app.models.service.NPuertasDaoImplement;
import com.brabbit.springboot.app.models.service.TipoCarroDaoImplement;
import com.brabbit.springboot.app.models.service.TipoGasDaoImplement;
import com.brabbit.springboot.app.models.service.TipoUsuarioDaoImplement;
import com.brabbit.springboot.app.models.service.UsuarioDaoImplement;
import com.brabbit.springboot.app.models.service.VehiculoDaoImplement;
import com.brabbit.springboot.app.models.entity.TipoUsuario;
import com.brabbit.springboot.app.models.entity.Usuario;
import com.brabbit.springboot.app.models.entity.Vehiculo;

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
	private ChoferDaoImplement choferDao;
	
	@Autowired
	private DuenioDaoImplement duenioDao;
	
	@Autowired
	private VehiculoDaoImplement vehiculoDao;
	
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
		String hora_entrada = entrada + ":00";
		String hora_salida = salida + ":00";
		usuario.setHora_ingreso(entrada);
		usuario.setHora_salida(salida);
		usuario.setID_DIRECCION(direccion);
		
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
	
}

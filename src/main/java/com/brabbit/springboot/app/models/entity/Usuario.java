package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_USUARIO;
	
	private String nombre;
	private String paterno;
	private String materno;
	
	private String fotografia;
	
	 @Size(max = 10)
	private String celular;
	private String casa;
	
	private String correo;
	
	private String instituto;
	
	private String hora_ingreso;
	private String hora_salida;
	
	@Temporal(TemporalType.DATE)
	private Date fRegistro;
	
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_TIPO")
	private TipoUsuario ID_TIPO;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_DIRECCION")
	private Direccion ID_DIRECCION;
	
	 @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    private List<Viaje> viajes = new ArrayList<>();


	public long getID_USUARIO() {
		return ID_USUARIO;
	}



	public void setID_USUARIO(long iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}



	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}



	public List<Viaje> getViajes() {
		return viajes;
	}



	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}



	public String getMaterno() {
		return materno;
	}



	public void setMaterno(String materno) {
		this.materno = materno;
	}



	public String getFotografia() {
		return fotografia;
	}



	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}



	public String getCelular() {
		return celular;
	}

	public  void setCelular(String celular) {
		this.celular=celular;
	}

	public String getCasa() {
		return casa;
	}



	public void setCasa(String casa) {
		this.casa = casa;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getInstituto() {
		return instituto;
	}



	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}


/*
	public Time getHora_ingreso() {
		return hora_ingreso;
	}



	public void setHora_ingreso(Time hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}



	public Time getHora_salida() {
		return hora_salida;
	}



	public void setHora_salida(Time hora_salida) {
		this.hora_salida = hora_salida;
	}
	
	*/
	



	public Date getfRegistro() {
		return fRegistro;
	}



	public String getHora_ingreso() {
		return hora_ingreso;
	}



	public void setHora_ingreso(String hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}



	public String getHora_salida() {
		return hora_salida;
	}



	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}



	public void setfRegistro(Date fRegistro) {
		this.fRegistro = fRegistro;
	}

	public TipoUsuario getID_TIPO() {
		return ID_TIPO;
	}



	public void setID_TIPO(TipoUsuario iD_TIPO) {
		ID_TIPO = iD_TIPO;
	}


	public Direccion getID_DIRECCION() {
		return ID_DIRECCION;
	}



	public void setID_DIRECCION(Direccion iD_DIRECCION) {
		ID_DIRECCION = iD_DIRECCION;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}

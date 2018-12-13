package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


@Entity
@Table(name="DUENIO")
public class Duenio implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_DUENIO;
	
	private String rfc;
	private String nombre;
	private String paterno;
	private String materno;
	
	@Size(max = 10)
	private String licencia;
	
	private String fotografia;
	private String correo;
	
	@Size(max = 10)
	private String celular;
	
	 @Temporal(TemporalType.DATE)
	    private Date fRegistro;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_DIRECCION")
	private Direccion ID_DIRECCION;

	
	public long getID_DUENIO() {
		return ID_DUENIO;
	}


	public void setID_DUENIO(long iD_DUENIO) {
		ID_DUENIO = iD_DUENIO;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
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


	public String getMaterno() {
		return materno;
	}


	public void setMaterno(String materno) {
		this.materno = materno;
	}


	public String getLicencia() {
		return licencia;
	}


	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}


	public String getFotografia() {
		return fotografia;
	}


	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public Date getfRegistro() {
		return fRegistro;
	}


	public void setfRegistro(Date fRegistro) {
		this.fRegistro = fRegistro;
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

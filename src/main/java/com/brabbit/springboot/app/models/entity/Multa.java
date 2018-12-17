package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="MULTA")
public class Multa implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_MULTA;
	
	private String lugar;
	
	private Time hora;
	
	private String agente;
	
	private String info;
	
	private int monto;
	
	
	/*Relacion ManyToOne por que un dueño puede registrar varios vehiculos*/
	 @ManyToOne	
	    @JoinColumn(name="licencia")
	    private Chofer licencia;
	 
	 public Vehiculo getMatricula() {
		return matricula;
	}



	public void setMatricula(Vehiculo matricula) {
		this.matricula = matricula;
	}






	/*Relacion ManyToOne por que un dueño puede registrar varios vehiculos*/
	 @ManyToOne	
	    @JoinColumn(name="matricula")
	    private Vehiculo matricula;
	 
	public long getID_MULTA() {
		return ID_MULTA;
	}



	public void setID_MULTA(long iD_MULTA) {
		ID_MULTA = iD_MULTA;
	}



	public String getLugar() {
		return lugar;
	}



	public void setLugar(String lugar) {
		this.lugar = lugar;
	}



	public Time getHora() {
		return hora;
	}



	public void setHora(Time hora) {
		this.hora = hora;
	}



	public String getAgente() {
		return agente;
	}



	public void setAgente(String agente) {
		this.agente = agente;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public int getMonto() {
		return monto;
	}



	public void setMonto(int monto) {
		this.monto = monto;
	}



	


	public Chofer getLicencia() {
		return licencia;
	}



	public void setLicencia(Chofer licencia) {
		this.licencia = licencia;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}

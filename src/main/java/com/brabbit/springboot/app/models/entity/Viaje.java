package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="VIAJE")
public class Viaje implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_VIAJE;
	
	private Time tiempo;
	private int pasajeros;
	private String origen;
	private String destino;
	private int cobro;

	@ManyToMany(mappedBy = "viajes")
    private List<Usuario> usuario = new ArrayList<>();
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_CHOFER")
	private Chofer ID_CHOFER;
	
	
	
	public long getID_VIAJE() {
		return ID_VIAJE;
	}



	public void setID_VIAJE(long iD_VIAJE) {
		ID_VIAJE = iD_VIAJE;
	}



	public Time getTiempo() {
		return tiempo;
	}



	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}



	public int getPasajeros() {
		return pasajeros;
	}



	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}



	public String getOrigen() {
		return origen;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public int getCobro() {
		return cobro;
	}



	public void setCobro(int cobro) {
		this.cobro = cobro;
	}



	public List<Usuario> getUsuario() {
		return usuario;
	}



	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}



	public Chofer getID_CHOFER() {
		return ID_CHOFER;
	}



	public void setID_CHOFER(Chofer iD_CHOFER) {
		ID_CHOFER = iD_CHOFER;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}

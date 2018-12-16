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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="VIAJE")
public class Viaje implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_VIAJE;
	
	private int distancia;
	private int tiempo;
	private int pasajeros;
	
	/*Estos datos son para tener el string de a donde se dirige el usuario, no sirven mas que para mostrar*/
	private String origin;
	private String destiny;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_ORIGEN")
	private Origen ID_ORIGEN;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_DESTINO")
	private Destino ID_DESTINO;

	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_CHOFER")
	private Chofer ID_CHOFER;
	
	@ManyToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_USUARIO")
	private Usuario ID_USUARIO;
	
	/*cobro sera objeto de viaje, e ira conectado al usuario*/
	private int cobro;
	
	
	
		public int getCobro() {
		return cobro;
	}



	public String getOrigin() {
			return origin;
		}



		public void setOrigin(String origin) {
			this.origin = origin;
		}



		public String getDestiny() {
			return destiny;
		}



		public void setDestiny(String destiny) {
			this.destiny = destiny;
		}



	public void setCobro(int cobro) {
		this.cobro = cobro;
	}



		public long getID_VIAJE() {
		return ID_VIAJE;
	}



	public void setID_VIAJE(long iD_VIAJE) {
		ID_VIAJE = iD_VIAJE;
	}



	public int getDistancia() {
		return distancia;
	}



	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}



	public int getTiempo() {
		return tiempo;
	}



	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}



	public int getPasajeros() {
		return pasajeros;
	}



	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}



	public Origen getID_ORIGEN() {
		return ID_ORIGEN;
	}



	public void setID_ORIGEN(Origen iD_ORIGEN) {
		ID_ORIGEN = iD_ORIGEN;
	}



	public Destino getID_DESTINO() {
		return ID_DESTINO;
	}



	public void setID_DESTINO(Destino iD_DESTINO) {
		ID_DESTINO = iD_DESTINO;
	}



	public Chofer getID_CHOFER() {
		return ID_CHOFER;
	}



	public void setID_CHOFER(Chofer iD_CHOFER) {
		ID_CHOFER = iD_CHOFER;
	}



	public Usuario getID_USUARIO() {
		return ID_USUARIO;
	}



	public void setID_USUARIO(Usuario iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}



		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}

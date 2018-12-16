package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DESTINO")
public class Destino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_DESTINO;
	
	private String destino;

	public long getID_DESTINO() {
		return ID_DESTINO;
	}

	public void setID_DESTINO(long iD_DESTINO) {
		ID_DESTINO = iD_DESTINO;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}	
	
	
	
}

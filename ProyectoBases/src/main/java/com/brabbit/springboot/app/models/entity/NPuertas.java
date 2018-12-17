package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NPUERTAS")
public class NPuertas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_PUERTAS;
	
	private int puertas;

	public long getID_PUERTAS() {
		return ID_PUERTAS;
	}

	public void setID_PUERTAS(long iD_PUERTAS) {
		ID_PUERTAS = iD_PUERTAS;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	
	
}

package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORIGEN")
public class Origen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_ORIGEN;
	
	private String origen;

	public long getID_ORIGEN() {
		return ID_ORIGEN;
	}

	public void setID_ORIGEN(long iD_ORIGEN) {
		ID_ORIGEN = iD_ORIGEN;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}	
	
	
}

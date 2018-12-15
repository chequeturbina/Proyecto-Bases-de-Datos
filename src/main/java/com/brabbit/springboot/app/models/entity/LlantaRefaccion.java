package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LREFACCION")
public class LlantaRefaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_REFACCION;
	
	private String refaccion;

	public long getID_REFACCION() {
		return ID_REFACCION;
	}

	public void setID_REFACCION(long iD_REFACCION) {
		ID_REFACCION = iD_REFACCION;
	}

	public String getRefaccion() {
		return refaccion;
	}

	public void setRefaccion(String refaccion) {
		this.refaccion = refaccion;
	}
	
	
}

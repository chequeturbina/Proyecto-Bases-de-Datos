package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPOGAS")
public class TipoGas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_TIPOGAS;
	
	private String tipogas;

	public long getID_TIPOGAS() {
		return ID_TIPOGAS;
	}

	public void setID_TIPOGAS(long iD_TIPOGAS) {
		ID_TIPOGAS = iD_TIPOGAS;
	}

	public String getTipogas() {
		return tipogas;
	}

	public void setTipogas(String tipogas) {
		this.tipogas = tipogas;
	}
	
	
}

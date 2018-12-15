package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPOCARRO")
public class TipoCarro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_TIPOCARRO;
	
	private String tipocarro;

	public long getID_TIPOCARRO() {
		return ID_TIPOCARRO;
	}

	public void setID_TIPOCARRO(long iD_TIPOCARRO) {
		ID_TIPOCARRO = iD_TIPOCARRO;
	}

	public String getTipocarro() {
		return tipocarro;
	}

	public void setTipocarro(String tipocarro) {
		this.tipocarro = tipocarro;
	}
	
	
}

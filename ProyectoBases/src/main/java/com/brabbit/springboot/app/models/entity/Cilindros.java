package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CILINDROS")
public class Cilindros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_CILINDROS;
	
	private int cilindros;

	public long getID_CILINDROS() {
		return ID_CILINDROS;
	}

	public void setID_CILINDROS(long iD_CILINDROS) {
		ID_CILINDROS = iD_CILINDROS;
	}

	public int getCilindros() {
		return cilindros;
	}

	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}
	
	
}

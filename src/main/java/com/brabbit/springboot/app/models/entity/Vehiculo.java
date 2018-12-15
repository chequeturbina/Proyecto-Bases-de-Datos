package com.brabbit.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="VEHICULO")
public class Vehiculo implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_VEHICULO;
	
	private String modelo;
	private String marca;
	private String matricula;
	private int anio;
	private int pasajeros;
	private int capacidad;
	
	@Column(nullable = true)
	private String seguro;
	@Column(nullable = true)
	private String tipo_seguro;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_CHOFER")
	private Chofer ID_CHOFER;
	
	/* Relaciones con las tablas normalizadas de no. puertas, llanta refaccion, el tipo de carro, el tipo de gasolina, y le numero de cilindros*/
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_PUERTAS")
	private NPuertas ID_PUERTAS;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_REFACCION")
	private LlantaRefaccion ID_REFACCION;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_TIPOCARRO")
	private TipoCarro ID_TIPOCARRO;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_TIPOGAS")
	private TipoGas ID_TIPOGAS;
	
	@OneToOne(cascade={CascadeType.ALL})
	  @JoinColumn(name="ID_CILINDROS")
	private Cilindros ID_CILINDROS;
	
	/*Relacion ManyToOne por que un dueño puede registrar varios vehiculos*/
	 @ManyToOne	
	    @JoinColumn(name="RFC")
	    private Duenio RFC;
	
	public long getID_VEHICULO() {
		return ID_VEHICULO;
	}



	public void setID_VEHICULO(long iD_VEHICULO) {
		ID_VEHICULO = iD_VEHICULO;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public int getAnio() {
		return anio;
	}



	public void setAnio(int anio) {
		this.anio = anio;
	}



	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}



	public int getCapacidad() {
		return capacidad;
	}



	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public String getSeguro() {
		return seguro;
	}



	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}



	public String getTipo_seguro() {
		return tipo_seguro;
	}



	public void setTipo_seguro(String tipo_seguro) {
		this.tipo_seguro = tipo_seguro;
	}



	public Chofer getID_CHOFER() {
		return ID_CHOFER;
	}



	public void setID_CHOFER(Chofer iD_CHOFER) {
		ID_CHOFER = iD_CHOFER;
	}
	
	public NPuertas getID_PUERTAS() {
		return ID_PUERTAS;
	}



	public void setID_PUERTAS(NPuertas iD_PUERTAS) {
		ID_PUERTAS = iD_PUERTAS;
	}



	public LlantaRefaccion getID_REFACCION() {
		return ID_REFACCION;
	}



	public void setID_REFACCION(LlantaRefaccion iD_REFACCION) {
		ID_REFACCION = iD_REFACCION;
	}



	public TipoCarro getID_TIPOCARRO() {
		return ID_TIPOCARRO;
	}



	public void setID_TIPOCARRO(TipoCarro iD_TIPOCARRO) {
		ID_TIPOCARRO = iD_TIPOCARRO;
	}



	public TipoGas getID_TIPOGAS() {
		return ID_TIPOGAS;
	}



	public void setID_TIPOGAS(TipoGas iD_TIPOGAS) {
		ID_TIPOGAS = iD_TIPOGAS;
	}



	public Cilindros getID_CILINDROS() {
		return ID_CILINDROS;
	}



	public void setID_CILINDROS(Cilindros iD_CILINDROS) {
		ID_CILINDROS = iD_CILINDROS;
	}



	public int getPasajeros() {
		return pasajeros;
	}

	


	public Duenio getRFC() {
		return RFC;
	}



	public void setRFC(Duenio rFC) {
		RFC = rFC;
	}
	
	

	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}

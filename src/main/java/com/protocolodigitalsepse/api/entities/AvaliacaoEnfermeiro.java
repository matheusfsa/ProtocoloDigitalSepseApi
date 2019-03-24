package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacaoEnfermeiro")
public class AvaliacaoEnfermeiro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8732312006979061735L;
	private int id;
	private String coren;
	private String registro;
	private int resultado;
	private Date data;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="coren", nullable = false)
	public String getCoren() {
		return coren;
	}
	public void setCoren(String coren) {
		this.coren = coren;
	}
	@Column(name="resultado", nullable = false)
	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Column(name="registro", nullable = false)
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	@Column(name="data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}


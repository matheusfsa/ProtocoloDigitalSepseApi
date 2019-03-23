package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacaoEnfermeiro")
public class AvaliacaoEnfermeiro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8732312006979061735L;
	private long id;
	private String crem;
	private String registro;
	private int resultado;
	@Id
	@Column(name="id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Id
	@Column(name="crem", nullable = false)
	public String getCrem() {
		return crem;
	}
	public void setCrem(String crem) {
		this.crem = crem;
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
}


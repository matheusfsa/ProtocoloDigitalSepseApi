package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avMedOp")
public class AvMedOp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5033955392511359300L;
	@EmbeddedId private AvMedOpId avMedOpId;
	private int tipo;
	private int resultado;
	public AvMedOp() {
		avMedOpId = new AvMedOpId();
	}
	public int getIdAv() {
		return avMedOpId.getIdAv();
	}

	public void setIdAv(int idAv) {
		avMedOpId.setIdAv(idAv);
	}
	@Column(name="tipo", nullable = false)
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getOpcao() {
		return avMedOpId.getOpcao();
	}
	public void setOpcao(String opcao) {
		avMedOpId.setOpcao(opcao);
	}
	@Column(name="resultado", nullable = false)
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}


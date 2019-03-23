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
	private String tipo;
	private String resultado;
	public long getId_av() {
		return avMedOpId.getId_av();
	}

	public void setId_av(long id_av) {
		avMedOpId.setId_av(id_av);
	}
	@Column(name="tipo", nullable = false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getOpcao() {
		return avMedOpId.getOpcao();
	}
	public void setOpcao(String opcao) {
		avMedOpId.setOpcao(opcao);
	}
	@Column(name="resultado", nullable = false)
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}


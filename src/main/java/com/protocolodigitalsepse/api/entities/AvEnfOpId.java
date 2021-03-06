package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvEnfOpId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3472050983929188739L;
	private int idAv;
	private String opcao;
	
	@Column(name="id_av", nullable = false)
	public int getIdAv() {
		return idAv;
	}

	public void setIdAv(int idAv) {
		this.idAv = idAv;
	}
	@Column(name="opcao", nullable = false)
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
}

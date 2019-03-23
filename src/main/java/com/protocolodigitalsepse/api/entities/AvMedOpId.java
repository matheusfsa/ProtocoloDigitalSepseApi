package com.protocolodigitalsepse.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class AvMedOpId {
	private long id_av;
	private String opcao;
	
	@Column(name="id_av", nullable = false)
	public long getId_av() {
		return id_av;
	}

	public void setId_av(long id_av) {
		this.id_av = id_av;
	}
	@Column(name="opcao", nullable = false)
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
}

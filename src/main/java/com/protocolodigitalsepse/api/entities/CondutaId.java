package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class CondutaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7675422942990305042L;
	private int id_avaliacao;
	private String descricao;
	@Column(name="id_avaliacao", nullable = false)
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	@Column(name="descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

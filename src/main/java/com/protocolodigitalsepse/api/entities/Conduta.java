package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conduta")
public class Conduta implements Serializable{

	private static final long serialVersionUID = -8530948764800844314L;
	@EmbeddedId private CondutaId condutaId;
	private Date data;
	private int executada;
	@Column(name="id_avaliacao", nullable = false)
	public int getId_avaliacao() {
		return condutaId.getId_avaliacao();
	}
	public void setId_avaliacao(int id_avaliacao) {
		condutaId.setId_avaliacao(id_avaliacao);
	}
	@Column(name="data", nullable = false)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Column(name="executada", nullable = false)
	public int getExecutada() {
		return executada;
	}
	public void setExecutada(int executada) {
		this.executada = executada;
	}

	public String getDescricao() {
		return condutaId.getDescricao();
	}
	public void setDescricao(String descricao) {
		condutaId.setDescricao(descricao);
	}
	
}

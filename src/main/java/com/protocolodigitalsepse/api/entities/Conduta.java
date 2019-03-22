package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conduta")
public class Conduta implements Serializable{

	private static final long serialVersionUID = -8530948764800844314L;
	private int id_avaliacao;
	private Date data;
	private int executada;
	private String descricao;
	@Id
	@Column(name="id_avaliacao", nullable = false)
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	@Id
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
	@Id
	@Column(name="descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

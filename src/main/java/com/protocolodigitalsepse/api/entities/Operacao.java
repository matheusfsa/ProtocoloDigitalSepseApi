package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="operacao")
public class Operacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1389896946731015430L;
	private Long idCheckList;
	private Date data_hora;
	private String operacao;
	private int res;
	private String comentario;
	@Id
	@Column(name="idCheckList", nullable = false)
	public Long getIdCheckList() {
		return idCheckList;
	}
	public void setId(Long idCheckList) {
		this.idCheckList = idCheckList;
	}
	@Column(name="data_hora", nullable = false)
	public Date getData_hora() {
		return data_hora;
	}
	
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	@Column(name="operacao", nullable = false)
	public String getOperacao() {
		return operacao;
	}
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	@Column(name="res", nullable = false)
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	@Column(name="comentario", nullable = true)
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}

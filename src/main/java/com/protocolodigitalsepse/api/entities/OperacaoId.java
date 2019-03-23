package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OperacaoId implements Serializable{
	private static final long serialVersionUID = -6383576513938130863L;
	private int idCheckList;
	private String operacao;
	public OperacaoId(int idCheckList, String operacao) {
		this.idCheckList = idCheckList;
		this.operacao = operacao;
	}
	public OperacaoId() {
	}
	@Column(name="idCheckList", nullable = false)
	public int getIdCheckList() {
		return idCheckList;
	}
	public void setIdCheckList(int idCheckList) {
		this.idCheckList = idCheckList;
	}
	@Column(name="operacao", nullable = false)
	public String getOperacao() {
		return operacao;
	}
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
}

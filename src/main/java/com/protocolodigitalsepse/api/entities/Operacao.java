package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
	@EmbeddedId private OperacaoId operacaoId;
	private Date data_hora;
	private int res;
	private String comentario;
	
	public  Operacao() {
		this.operacaoId = new OperacaoId();
	}
	@Column(name="data_hora", nullable = false)
	public Date getData_hora() {
		return data_hora;
	}
	
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
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
	public int getIdCheckList() {
		return operacaoId.getIdCheckList();
	}
	public void setIdCheckList(int idCheckList) {
		operacaoId.setIdCheckList(idCheckList);
	}
	public String getOperacao() {
		return operacaoId.getOperacao();
	}
	
	public void setOperacao(String operacao) {
		operacaoId.setOperacao(operacao);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Operacao [id_check_list = "+operacaoId.getIdCheckList()+", operacao = " + operacaoId.getOperacao() + "]";
	}

	public OperacaoId getOperacaoId() {
		return operacaoId;
	}

	public void setOperacaoId(OperacaoId operacaoId) {
		this.operacaoId = operacaoId;
	}
	
	
}

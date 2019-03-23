package com.protocolodigitalsepse.api.dtos;

import java.util.Date;

public class OperacaoDto {
	private long idCheckList;
	private String data_hora;
	private String operacao;
	private int res;
	private String comentario;
	public long getIdCheckList() {
		return idCheckList;
	}
	public void setIdCheckList(long idCheckList) {
		this.idCheckList = idCheckList;
	}
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}

package com.protocolodigitalsepse.api.dtos;





public class CondutaDto {
	private int id_avaliacao;
	private String data;
	private int executada;
	private String descricao;
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getExecutada() {
		return executada;
	}
	public void setExecutada(int executada) {
		this.executada = executada;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

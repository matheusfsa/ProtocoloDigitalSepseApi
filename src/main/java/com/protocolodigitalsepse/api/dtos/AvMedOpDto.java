package com.protocolodigitalsepse.api.dtos;



public class AvMedOpDto {

	private long id_av;
	private String tipo;
	private String opcao;
	private String resultado;
	public long getId_av() {
		return id_av;
	}
	public void setId_av(long id_av) {
		this.id_av = id_av;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}


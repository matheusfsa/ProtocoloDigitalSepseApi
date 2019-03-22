package com.protocolodigitalsepse.api.dtos;

public class AvaliacaoEnfermeiroDto{
	private long id;
	private String crem;
	private String registro;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCrem() {
		return crem;
	}
	public void setCrem(String crem) {
		this.crem = crem;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
}

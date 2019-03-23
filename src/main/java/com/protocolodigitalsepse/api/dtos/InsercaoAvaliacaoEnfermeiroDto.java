package com.protocolodigitalsepse.api.dtos;

import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvEnfOp;

public class InsercaoAvaliacaoEnfermeiroDto{
	private String coren;
	private String registro;
	
	public String getCoren() {
		return coren;
	}
	public void setCrem(String coren) {
		this.coren = coren;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}

}

package com.protocolodigitalsepse.api.dtos;

import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvMedOp;

public class AvMedOpDto {

	private int idAv;
	private int tipo;
	private String opcao;
	private int resultado;
	public int getIdAv() {
		return idAv;
	}
	public void setIdAv(int idAv) {
		this.idAv = idAv;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public static ArrayList<AvMedOpDto> convertToAvMedOpDto(ArrayList<AvMedOp> ops) {
		ArrayList<AvMedOpDto> res = new ArrayList<AvMedOpDto>();
		for (AvMedOp avMedOp : ops) {
			AvMedOpDto a = new AvMedOpDto();
			a.setIdAv(avMedOp.getIdAv());
			a.setOpcao(avMedOp.getOpcao());
			a.setResultado(avMedOp.getResultado());
			a.setTipo(avMedOp.getTipo());
			res.add(a);
		}
		return res;
	}
	public static ArrayList<AvMedOp> convertToAvMedOp(ArrayList<AvMedOpDto> ops) {
		ArrayList<AvMedOp> res = new ArrayList<AvMedOp>();
		for (AvMedOpDto avMedOpDto : ops) {
			AvMedOp a = new AvMedOp();
			a.setIdAv(avMedOpDto.getIdAv());
			a.setOpcao(avMedOpDto.getOpcao());
			a.setResultado(avMedOpDto.getResultado());
			a.setTipo(avMedOpDto.getTipo());
			res.add(a);
		}
		return res;
	}
	
}


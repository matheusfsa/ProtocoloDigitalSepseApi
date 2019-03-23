package com.protocolodigitalsepse.api.dtos;

import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvMedOp;

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
	public static ArrayList<AvMedOpDto> convertToAvMedOpDto(ArrayList<AvMedOp> ops) {
		ArrayList<AvMedOpDto> res = new ArrayList<AvMedOpDto>();
		for (AvMedOp avMedOp : ops) {
			AvMedOpDto a = new AvMedOpDto();
			a.setId_av(avMedOp.getId_av());
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
			a.setId_av(avMedOpDto.getId_av());
			a.setOpcao(avMedOpDto.getOpcao());
			a.setResultado(avMedOpDto.getResultado());
			a.setTipo(avMedOpDto.getTipo());
			res.add(a);
		}
		return res;
	}
	
}


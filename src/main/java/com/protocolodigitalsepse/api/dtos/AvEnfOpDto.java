package com.protocolodigitalsepse.api.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvEnfOp;

public class AvEnfOpDto {

	private int id_av;
	private int tipo;
	private String opcao;
	private int resultado;
	
	public int getId_av() {
		return id_av;
	}

	public void setId_av(int id_av) {
		this.id_av = id_av;
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
	public static ArrayList<AvEnfOpDto> convertToAvEnfOpDto(ArrayList<AvEnfOp> ops) {
		ArrayList<AvEnfOpDto> res = new ArrayList<AvEnfOpDto>();
		for (AvEnfOp avEnfOp : ops) {
			AvEnfOpDto a = new AvEnfOpDto();
			a.setId_av(avEnfOp.getIdAv());
			a.setOpcao(avEnfOp.getOpcao());
			a.setResultado(avEnfOp.getResultado());
			a.setTipo(avEnfOp.getTipo());
			res.add(a);
		}
		return res;
	}
	public static ArrayList<AvEnfOp> convertToAvEnfOp(ArrayList<AvEnfOpDto> ops) {
		ArrayList<AvEnfOp> res = new ArrayList<AvEnfOp>();
		for (AvEnfOpDto avEnfOpDto : ops) {
			AvEnfOp a = new AvEnfOp();
			a.setIdAv(avEnfOpDto.getId_av());
			a.setOpcao(avEnfOpDto.getOpcao());
			a.setResultado(avEnfOpDto.getResultado());
			a.setTipo(avEnfOpDto.getTipo());
			res.add(a);
		}
		return res;
	}
}


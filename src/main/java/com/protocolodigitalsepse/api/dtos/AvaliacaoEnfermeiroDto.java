package com.protocolodigitalsepse.api.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvEnfOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoEnfermeiro;
import com.protocolodigitalsepse.api.entities.Operacao;

public class AvaliacaoEnfermeiroDto{
	private int id;
	private String coren;
	private String registro;
	private ArrayList<AvEnfOp> ops;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoren() {
		return coren;
	}
	public void setCoren(String coren) {
		this.coren = coren;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public static AvaliacaoEnfermeiroDto convertToAvaliacaoEnfermeiroDto(AvaliacaoEnfermeiro avaliacaoEnfermeiro, ArrayList<AvEnfOpDto> ops) {
		AvaliacaoEnfermeiroDto res = new AvaliacaoEnfermeiroDto();
		res.setCoren(avaliacaoEnfermeiro.getCoren());
		res.setId(avaliacaoEnfermeiro.getId());
		res.setRegistro(avaliacaoEnfermeiro.getRegistro());
		res.setOps(AvEnfOpDto.convertToAvEnfOp(ops));
		return res;
	}
	public static AvaliacaoEnfermeiro convertToAvaliacaoEnfermeiro(AvaliacaoEnfermeiroDto avaliacaoEnfermeiroDto){
		
		AvaliacaoEnfermeiro res = new AvaliacaoEnfermeiro();
		res.setCoren(avaliacaoEnfermeiroDto.getCoren());
		res.setId(avaliacaoEnfermeiroDto.getId());
		res.setRegistro(avaliacaoEnfermeiroDto.getRegistro());
		return res;
	}
	public ArrayList<AvEnfOp> getOps() {
		return ops;
	}
	public void setOps(ArrayList<AvEnfOp> ops) {
		this.ops = ops;
	}
}

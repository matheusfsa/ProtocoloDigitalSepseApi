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
	private String data;
	private ArrayList<AvEnfOpDto> ops;
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
	public static AvaliacaoEnfermeiroDto convertToAvaliacaoEnfermeiroDto(AvaliacaoEnfermeiro avaliacaoEnfermeiro, ArrayList<AvEnfOp> ops) {
		AvaliacaoEnfermeiroDto res = new AvaliacaoEnfermeiroDto();
		res.setCoren(avaliacaoEnfermeiro.getCoren());
		res.setId(avaliacaoEnfermeiro.getId());
		res.setRegistro(avaliacaoEnfermeiro.getRegistro());
		res.setOps(AvEnfOpDto.convertToAvEnfOpDto(ops));
		res.setData(avaliacaoEnfermeiro.getData().toString());
		return res;
	}
	public static AvaliacaoEnfermeiro convertToAvaliacaoEnfermeiro(AvaliacaoEnfermeiroDto avaliacaoEnfermeiroDto){
		
		AvaliacaoEnfermeiro res = new AvaliacaoEnfermeiro();
		res.setCoren(avaliacaoEnfermeiroDto.getCoren());
		res.setId(avaliacaoEnfermeiroDto.getId());
		res.setRegistro(avaliacaoEnfermeiroDto.getRegistro());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(avaliacaoEnfermeiroDto.getData() != null)
			try {
				res.setData(formatter.parse(avaliacaoEnfermeiroDto.getData().toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			res.setData(null);
		return res;
	}
	public ArrayList<AvEnfOpDto> getOps() {
		return ops;
	}
	public void setOps(ArrayList<AvEnfOpDto> ops) {
		this.ops = ops;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}

package com.protocolodigitalsepse.api.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.Conduta;

public class CondutaDto {
	private int id_avaliacao;
	private String data;
	private int executada;
	private String descricao;
	public int getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(int id_avaliacao) {
		this.id_avaliacao= id_avaliacao;
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
	public static ArrayList<CondutaDto> convertToCondutaDto(ArrayList<Conduta> ops) {
		ArrayList<CondutaDto> res = new ArrayList<CondutaDto>();
		for (Conduta conduta : ops) {
			CondutaDto a = new CondutaDto();
			a.setId_avaliacao(conduta.getId_avaliacao());
			a.setDescricao(conduta.getDescricao());
			a.setExecutada(conduta.getExecutada());
			a.setData(conduta.getData().toString());
			res.add(a);
		}
		return res;
	}
	public static ArrayList<Conduta> convertToConduta(ArrayList<CondutaDto> ops) {
		ArrayList<Conduta> res = new ArrayList<Conduta>();
		for (CondutaDto condutaDto : ops) {
			Conduta a = new Conduta();
			a.setId_avaliacao(condutaDto.getId_avaliacao());
			a.setDescricao(condutaDto.getDescricao());
			a.setExecutada(condutaDto.getExecutada());
			if(condutaDto.getData() != null)
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					a.setData(formatter.parse(condutaDto.getData()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				a.setData(null);
			res.add(a);
		}
		return res;
	}
	
}

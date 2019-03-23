package com.protocolodigitalsepse.api.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.protocolodigitalsepse.api.entities.Operacao;

public class OperacaoDto {
	private int idCheckList;
	private String data_hora;
	private String operacao;
	private int res;
	private String comentario;
	public int getIdCheckList() {
		return idCheckList;
	}
	public void setIdCheckList(int idCheckList) {
		this.idCheckList = idCheckList;
	}
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public static ArrayList<OperacaoDto> convertToOperacaoDto(ArrayList<Operacao> ops) {
		ArrayList<OperacaoDto> res = new ArrayList<OperacaoDto>();
		for (Operacao operacao : ops) {
			OperacaoDto o = new OperacaoDto();
			o.setComentario(operacao.getComentario());
			if(operacao.getData_hora() != null)
				o.setData_hora(operacao.getData_hora().toString());
			else
				o.setData_hora(null);
			o.setIdCheckList(operacao.getIdCheckList());
			o.setRes(operacao.getRes());
			o.setOperacao(operacao.getOperacao());
			res.add(o);
		}
		return res;
	}
	public static ArrayList<Operacao> convertToOperacao(ArrayList<OperacaoDto> ops) {
		ArrayList<Operacao> res = new ArrayList<Operacao>();
		for (OperacaoDto operacaoDto : ops) {
			Operacao o = new Operacao();
			o.setComentario(operacaoDto.getComentario());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(operacaoDto.getData_hora() != null)
				try {
					o.setData_hora(formatter.parse(operacaoDto.getData_hora()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				o.setData_hora(null);
			o.setIdCheckList(operacaoDto.getIdCheckList());
			o.setRes(operacaoDto.getRes());
			o.setOperacao(operacaoDto.getOperacao());
			res.add(o);
		}
		return res;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OperacaoDto [id_check_list = "+idCheckList+", operacao = " + operacao + "]";
	}
}

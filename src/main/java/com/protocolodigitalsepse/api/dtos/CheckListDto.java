package com.protocolodigitalsepse.api.dtos;

import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.Operacao;

public class CheckListDto{
	private int id;
	private String data_diag;
	private String reg_paciente;
	private String nick_prof;
	private String data_inicio;
	private String data_fim;
	private String comentario;
	private int pacote;
	private ArrayList<OperacaoDto> ops;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData_diag() {
		return data_diag;
	}
	public void setData_diag(String data_diag) {
		this.data_diag = data_diag;
	}
	public String getReg_paciente() {
		return reg_paciente;
	}
	public void setReg_paciente(String reg_paciente) {
		this.reg_paciente = reg_paciente;
	}
	public String getNick_prof() {
		return nick_prof;
	}
	public void setNick_prof(String nick_prof) {
		this.nick_prof = nick_prof;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getPacote() {
		return pacote;
	}
	public void setPacote(int pacote) {
		this.pacote = pacote;
	}
	public ArrayList<OperacaoDto> getOps() {
		return ops;
	}
	public void setOps(ArrayList<OperacaoDto> ops) {
		this.ops = ops;
	}
	
	
}


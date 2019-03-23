package com.protocolodigitalsepse.api.dtos;

import java.util.ArrayList;

public class InsercaoCheckListDto {
	private String data_diag;
	private String reg_paciente;
	private String nick_prof;
	private int pacote;
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
	
	public int getPacote() {
		return pacote;
	}
	public void setPacote(int pacote) {
		this.pacote = pacote;
	}

	
}

package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkList")
public class CheckList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9194756103931855307L;
	private int id;
	private Date data_diag;
	private String reg_paciente;
	private String nick_prof;
	private Date data_inicio;
	private Date data_fim;
	private String comentario;
	@Id
	@Column(name="id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="data_diag", nullable = false)
	public Date getData_diag() {
		return data_diag;
	}
	public void setData_diag(Date data_diag) {
		this.data_diag = data_diag;
	}
	@Column(name="reg_paciente", nullable = false)
	public String getReg_paciente() {
		return reg_paciente;
	}
	public void setReg_paciente(String reg_paciente) {
		this.reg_paciente = reg_paciente;
	}
	@Column(name="nick_prof", nullable = false)
	public String getNick_prof() {
		return nick_prof;
	}
	public void setNick_prof(String nick_prof) {
		this.nick_prof = nick_prof;
	}
	@Column(name="data_inicio", nullable = true)
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	@Column(name="data_fim", nullable = true)
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	@Column(name="comentario", nullable = true)
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}

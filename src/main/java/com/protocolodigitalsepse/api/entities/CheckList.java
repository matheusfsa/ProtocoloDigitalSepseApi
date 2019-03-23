package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String NickProf;
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
	public String getNickProf() {
		return NickProf;
	}
	public void setNickProf(String NickProf) {
		this.NickProf = NickProf;
	}
	@Column(name="data_inicio", nullable = true)
	public Date getData_inicio() {
		return data_inicio;
	}
	@Transient
	public Optional<Date> getData_inicioOpt() {
		return Optional.ofNullable(data_inicio);
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	@Column(name="data_fim", nullable = true)
	public Date getData_fim() {
		return data_fim;
	}
	@Transient
	public Optional<Date> getData_fimOpt() {
		return Optional.ofNullable(data_fim);
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	@Column(name="comentario", nullable = true)
	public String getComentario() {
		return comentario;
	}
	@Transient
	public Optional<String> getComentarioOpt() {
		return Optional.ofNullable(comentario);
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}


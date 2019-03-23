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
	private Date dataDiag;
	private String regPaciente;
	private String NickProf;
	private Date dataInicio;
	private Date dataFim;
	private String comentario;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="data_diag", nullable = false)
	public Date getDataDiag() {
		return dataDiag;
	}
	public void setDataDiag(Date ddataDiag) {
		this.dataDiag = ddataDiag;
	}
	@Column(name="reg_paciente", nullable = false)
	public String getRegPaciente() {
		return regPaciente;
	}
	public void setRegPaciente(String regPaciente) {
		this.regPaciente = regPaciente;
	}
	@Column(name="nick_prof", nullable = false)
	public String getNickProf() {
		return NickProf;
	}
	public void setNickProf(String NickProf) {
		this.NickProf = NickProf;
	}
	@Column(name="data_inicio", nullable = true)
	public Date getDataInicio() {
		return dataInicio;
	}
	@Transient
	public Optional<Date> getDataInicioOpt() {
		return Optional.ofNullable(dataInicio);
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	@Column(name="data_fim", nullable = true)
	public Date getDataFim() {
		return dataFim;
	}
	@Transient
	public Optional<Date> getDataFimOpt() {
		return Optional.ofNullable(dataFim);
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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


package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avMedOp")
public class AvMedOp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5033955392511359300L;
	private long id_av;
	private String tipo;
	private String opcao;
	private String resultado;
	@Id
	@Column(name="id_av", nullable = false)
	public Long getId_av() {
		return id_av;
	}

	public void setId(Long id_av) {
		this.id_av = id_av;
	}
	@Id
	@Column(name="tipo", nullable = false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column(name="opcao", nullable = false)
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	@Column(name="resultado", nullable = false)
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}


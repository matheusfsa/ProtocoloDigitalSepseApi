package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avEnfOp")
public class AvEnfOp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328589431005474716L;
	private long id_av;
	private String tipo;
	private String opcao;
	private String resultado;
	
	@Id
	@Column(name="id_av", nullable = false)
	public long getId_av() {
		return id_av;
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

	public void setId_av(long id_av) {
		this.id_av = id_av;
	}
}


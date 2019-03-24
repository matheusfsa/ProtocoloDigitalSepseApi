package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avEnfOp")
public class AvEnfOp implements Serializable{

	private static final long serialVersionUID = 3328589431005474716L;
	@EmbeddedId private AvEnfOpId avEnfOpId;
	private int tipo;
	private int resultado;
	public AvEnfOp() {
		avEnfOpId = new AvEnfOpId();
	}
	public int getIdAv() {
		return avEnfOpId.getIdAv();
	}

	public void setIdAv(int idAv) {
		avEnfOpId.setIdAv(idAv);
	}

	@Column(name="tipo", nullable = false)
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getOpcao() {
		return avEnfOpId.getOpcao();
	}
	public void setOpcao(String opcao) {
		avEnfOpId.setOpcao(opcao);
	}
	@Column(name="resultado", nullable = false)
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public AvEnfOpId getAvEnfOpId() {
		return avEnfOpId;
	}

	public void setAvEnfOpId(AvEnfOpId avEnfOpId) {
		this.avEnfOpId = avEnfOpId;
	}

}


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
	/**
	 * 
	 */
	private static final long serialVersionUID = 3328589431005474716L;
	@EmbeddedId private AvEnfOpId avEnfOpId;
	private String tipo;
	private String resultado;
	
	public long getId_av() {
		return avEnfOpId.getId_av();
	}

	public void setId_av(long id_av) {
		avEnfOpId.setId_av(id_av);
	}
	
	@Id
	@Column(name="tipo", nullable = false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOpcao() {
		return avEnfOpId.getOpcao();
	}
	public void setOpcao(String opcao) {
		avEnfOpId.setOpcao(opcao);
	}
	@Column(name="resultado", nullable = false)
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}


package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacaoMedico")
public class AvaliacaoMedico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3100836569793385328L;
	private long id;
	private String crm;
	private String registro;
	
	@Id
	@Column(name="id", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Id
	@Column(name="crm", nullable = false)
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	@Column(name="registro", nullable = false)
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
}


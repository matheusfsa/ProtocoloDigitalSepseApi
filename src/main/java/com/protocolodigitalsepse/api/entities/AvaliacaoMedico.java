
package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacaoMedico")
public class AvaliacaoMedico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3100836569793385328L;
	private int id;
	private String crm;
	private String registro;
	private int resultado;
	private Date data;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
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
	@Column(name="resultado", nullable = false)
	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	@Column(name="data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Avaliacão Médica [id = "+id+"]";
	}
}


package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enfermeiro")
public class Enfermeiro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3518486101457820612L;
	private String crem;
	private String nick_name;
	@Id
	@Column(name="crem", nullable = false)
	public String getCrm() {
		return crem;
	}
	public void setCrm(String crm) {
		this.crem = crm;
	}
	@Column(name="nick_name", nullable = false)
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
}


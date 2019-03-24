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
	private String coren;
	private String nickName;
	@Id
	@Column(name="coren", nullable = false)
	public String getCoren() {
		return coren;
	}
	public void setCoren(String coren) {
		this.coren = coren;
	}
	@Column(name="nick_name", nullable = false)
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}


package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medico")
public class Medico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1885938154856415419L;
	private String crm;
	private String nickName;
	@Id
	@Column(name="CRM", nullable = false)
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	@Column(name="nick_name", nullable = false)
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}

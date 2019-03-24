package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "profissionalSaude")
public class ProfissionalSaude implements Serializable{

	private static final long serialVersionUID = 6738001174672389130L;
	private String nickName;
	private String nome;
	private String sobrenome;
	private String senha;
	@Id
	@Column(name = "nick_name", nullable = false)
	public String getNickName() {
		return nickName;
	}
	
	public void setNick_name(String nickName) {
		this.nickName = nickName;
	}
	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "sobrenome", nullable = false)
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}

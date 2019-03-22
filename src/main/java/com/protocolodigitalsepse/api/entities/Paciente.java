package com.protocolodigitalsepse.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = -2028669782511377522L;
	private String nome;
	private String sobrenome;
	private Date data_nascimento;
	private String registro;
	private String sexo;
	private Boolean grupo_de_risco;
	
	public Paciente() {
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
	@Column(name = "razao_social", nullable = false)
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	@Column(name = "data_nascimento", nullable = false)
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	@Id
	@Column(name = "registro", nullable = false)
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	@Column(name = "sexo", nullable = true)
	public String getSexo() {
		return sexo;
	}
	@Transient
	public Optional<String> getSexoOpt() {
		return Optional.ofNullable(sexo);
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Column(name = "grupo_de_risco", nullable = true)
	public Boolean getGrupo_de_risco() {
		return grupo_de_risco;
	}
	@Transient
	public Optional<Boolean> getGrupo_de_riscoOpt() {
		return Optional.ofNullable(grupo_de_risco);
	}
	public void setGrupo_de_risco(boolean grupo_de_risco) {
		this.grupo_de_risco = grupo_de_risco;
	}
	
	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", sobrenome=" + sobrenome + ", data_nascimento=" + data_nascimento + ", registro=" + registro
				+ ", sexo=" + sexo + ", grupo_de_risco=" + sexo +"]";
	}

}

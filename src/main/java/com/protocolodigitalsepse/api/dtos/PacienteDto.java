package com.protocolodigitalsepse.api.dtos;


import java.util.Optional;

public class PacienteDto {
	private String nome;
	private String sobrenome;
	private String data_nascimento;
	private String registro;
	private Optional<String> sexo = Optional.empty();
	private Optional<String> grupo_de_risco = Optional.empty();
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public Optional<String> getSexo() {
		return sexo;
	}
	public void setSexo(Optional<String> sexo) {
		this.sexo = sexo;
	}
	public Optional<String> getGrupo_de_risco() {
		return grupo_de_risco;
	}
	public void setGrupo_de_risco(Optional<String> grupo_de_risco) {
		this.grupo_de_risco = grupo_de_risco;
	}
	@Override
	public String toString() {
		return "PacienteDto [nome=" + nome + ", sobrenome=" + sobrenome + ", data_nascimento=" + data_nascimento + ", registro=" + registro
				+ ", sexo=" + sexo + ", grupo_de_risco=" + grupo_de_risco +"]";
	}
}

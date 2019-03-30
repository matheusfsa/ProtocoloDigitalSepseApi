package com.protocolodigitalsepse.api.dtos;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import com.protocolodigitalsepse.api.entities.Paciente;

public class PacienteDto {
	private String nome;
	private String sobrenome;
	private String data_nascimento;
	private String registro;
	private int etapa;
	private String sexo;
	private String grupo_de_risco;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getGrupo_de_risco() {
		return grupo_de_risco;
	}
	public void setGrupo_de_risco(String grupo_de_risco) {
		this.grupo_de_risco = grupo_de_risco;
	}
	public Paciente toPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNome(nome);
		paciente.setSobrenome(getSobrenome());
		paciente.setRegistro(getRegistro());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			paciente.setData_nascimento(formatter.parse(getData_nascimento()));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		paciente.setSexo(sexo);
		if(grupo_de_risco.equals("1"))
			paciente.setGrupo_de_risco(true);
		else
			paciente.setGrupo_de_risco(false);
		return paciente;
	}
	@Override
	public String toString() {
		return "PacienteDto [nome=" + nome + ", sobrenome=" + sobrenome + ", data_nascimento=" + data_nascimento + ", registro=" + registro
				+ ", sexo=" + sexo + ", grupo_de_risco=" + grupo_de_risco +"]";
	}
	public int getEtapa() {
		return etapa;
	}
	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}
}

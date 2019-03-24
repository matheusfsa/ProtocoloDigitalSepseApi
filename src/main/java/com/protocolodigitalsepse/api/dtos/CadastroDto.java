package com.protocolodigitalsepse.api.dtos;

import com.protocolodigitalsepse.api.entities.ProfissionalSaude;

public class CadastroDto {
	private String nick_name;
	private String senha;
	private String nome;
	private String sobrenome;
	private int tipo;
	private String codigo;
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public MedicoDto toMedicoDto() {
		MedicoDto res  = new MedicoDto();
		res.setNick_name(nick_name);
		res.setCrm(codigo);
		return res;
	}
	public EnfermeiroDto toEnfermeiroDto() {
		EnfermeiroDto res = new EnfermeiroDto();
		res.setCoren(codigo);
		res.setNick_name(nick_name);
		return res;
	}
	public ProfissionalSaudeDto toProfissionalSaudeDto() {
		ProfissionalSaudeDto res = new ProfissionalSaudeDto();
		res.setNick_name(nick_name);
		res.setNome(nome);
		res.setSenha(senha);
		res.setSobrenome(sobrenome);
		return res;
	}
}

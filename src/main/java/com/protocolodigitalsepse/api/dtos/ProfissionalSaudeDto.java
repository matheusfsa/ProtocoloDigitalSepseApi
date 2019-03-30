package com.protocolodigitalsepse.api.dtos;

import com.protocolodigitalsepse.api.entities.Enfermeiro;
import com.protocolodigitalsepse.api.entities.Medico;
import com.protocolodigitalsepse.api.entities.ProfissionalSaude;

public class ProfissionalSaudeDto{
	private String nick_name;
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
	public Medico toMedico() {
		Medico res  = new Medico();
		res.setNickName(nick_name);
		res.setCrm(codigo);
		return res;
	}
	public Enfermeiro toEnfermeiro() {
		Enfermeiro res = new Enfermeiro();
		res.setCoren(codigo);
		res.setNickName(nick_name);
		return res;
	}
	public ProfissionalSaude toProfissionalSaude() {
		ProfissionalSaude res = new ProfissionalSaude();
		res.setNick_name(nick_name);
		res.setNome(nome);
		res.setSobrenome(sobrenome);
		return res;
	}
	public static ProfissionalSaudeDto toDto(ProfissionalSaude prof, int tipo, String codigo) {
		ProfissionalSaudeDto res = new ProfissionalSaudeDto();
		res.setNick_name(prof.getNickName());
		res.setNome(prof.getNome());
		res.setTipo(tipo);
		res.setCodigo(codigo);
		res.setSobrenome(prof.getSobrenome());
		return res;
	}
	
	
}

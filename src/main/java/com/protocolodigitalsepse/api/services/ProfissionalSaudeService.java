package com.protocolodigitalsepse.api.services;

import com.protocolodigitalsepse.api.dtos.ProfissionalSaudeDto;
import com.protocolodigitalsepse.api.entities.Enfermeiro;
import com.protocolodigitalsepse.api.entities.Medico;
import com.protocolodigitalsepse.api.entities.ProfissionalSaude;

public interface ProfissionalSaudeService {
	Medico buscarPorCrm(String crm);
	Enfermeiro buscarPorCoren(String coren);
	ProfissionalSaudeDto buscarPorNickName(String nick_name);
	boolean existe(String codigo);
	Medico persistirMedico(ProfissionalSaudeDto prof);
	Enfermeiro persistirEnfermeiro(ProfissionalSaudeDto prof);
	boolean existeNick(String nick_name);
	boolean validarProf(String nick_name, String senha);
}

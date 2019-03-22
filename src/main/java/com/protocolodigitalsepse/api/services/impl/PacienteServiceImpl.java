package com.protocolodigitalsepse.api.services.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.Paciente;
import com.protocolodigitalsepse.api.repositories.PacienteRepository;
import com.protocolodigitalsepse.api.services.PacienteService;
@Service
public class PacienteServiceImpl implements PacienteService {
	private static final Logger log = LoggerFactory.getLogger(PacienteServiceImpl.class);
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public Optional<Paciente> buscarPorRegistro(String registro) {
		log.info("Buscando paciente pelo registro {}", registro);
		List<Paciente> res = this.pacienteRepository.findByRegistro(registro);
		if(res.size()>0)
			return Optional.ofNullable(res.get(0));
		return Optional.ofNullable(null);
	}

	@Override
	public List<Paciente> buscarPacientesParaTratamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> buscarPacientesParaAvaliacao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> buscarPacientesAvaliacaoMed(String crm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> buscarPacientesAvaliacaoEnf(String crem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> buscarPacientesTratamentoProf(String nick_name) {
		// TODO Auto-generated method stub
		return null;
	}

}

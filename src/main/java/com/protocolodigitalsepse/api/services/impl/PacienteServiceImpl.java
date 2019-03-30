package com.protocolodigitalsepse.api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Paciente;
import com.protocolodigitalsepse.api.repositories.PacienteRepository;
import com.protocolodigitalsepse.api.services.CheckListService;
import com.protocolodigitalsepse.api.services.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
	private static final Logger log = LoggerFactory.getLogger(PacienteServiceImpl.class);
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private CheckListService checkListService;
	@Override
	public Optional<Paciente> buscarPorRegistro(String registro) {
		log.info("Buscando paciente pelo registro {}", registro);
		List<Paciente> res = this.pacienteRepository.findByRegistro(registro);
		if(res.size()>0)
			return Optional.ofNullable(res.get(0));
		return Optional.ofNullable(null);
	}
	@Override
	public List<Paciente> buscarPacientesEmTratamentoComProf(String nickProf) {
		// TODO Auto-generated method stub
		List<Paciente> res = new ArrayList<Paciente>();
		List<CheckList> checkLists = this.checkListService.buscarCheckListsNaoFinalizadosProf(nickProf);
		for (CheckList checkList : checkLists) {
			res.add(buscarPorRegistro(checkList.getRegPaciente()).get());
		}
		return res;
	}
	@Override
	public List<Paciente> buscarPacientesParaTratamento() {
		// TODO Auto-generated method stub
		List<Paciente> res = this.pacienteRepository.findByEtapa(2);
		return res;
	}

	@Override
	public List<Paciente> buscarPacientesParaAvaliacao() {
		// TODO Auto-generated method stub
		List<Paciente> res = this.pacienteRepository.findByEtapa(0);
		return res;
	}

	@Override
	public List<Paciente> buscarPacientesAvaliacaoMed() {
		List<Paciente> res = this.pacienteRepository.findByEtapa(1);
		return res;
	}

	@Override
	public List<Paciente> buscarPacientesAvaliacaoEnf() {
		// TODO Auto-generated method stur
		List<Paciente> res = this.pacienteRepository.findByEtapa(0);
		return res;
	}

	@Override
	public List<Paciente> buscarPacientesTratamentoProf(String nick_name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Paciente persistir(Paciente paciente) {
		// TODO Auto-generated method stub
		return this.pacienteRepository.save(paciente);
	}

}

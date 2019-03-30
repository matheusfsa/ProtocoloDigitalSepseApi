package com.protocolodigitalsepse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.dtos.ProfissionalSaudeDto;
import com.protocolodigitalsepse.api.entities.Enfermeiro;
import com.protocolodigitalsepse.api.entities.Medico;
import com.protocolodigitalsepse.api.entities.ProfissionalSaude;
import com.protocolodigitalsepse.api.repositories.EnfermeiroRepository;
import com.protocolodigitalsepse.api.repositories.MedicoRepository;
import com.protocolodigitalsepse.api.repositories.ProfissionalSaudeRepository;
import com.protocolodigitalsepse.api.services.ProfissionalSaudeService;
@Service
public class ProfisionalSaudeServiceImpl implements ProfissionalSaudeService {
	@Autowired
	MedicoRepository medicoRepository;
	@Autowired
	EnfermeiroRepository enfermeiroRepository;
	@Autowired
	ProfissionalSaudeRepository profissionalSaudeRepository;
	@Override
	public Medico buscarPorCrm(String crm) {
		List<Medico> res = medicoRepository.findByCrm(crm);
		if(res!=null) {
			return res.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Enfermeiro buscarPorCoren(String coren) {
		List<Enfermeiro> res = enfermeiroRepository.findByCoren(coren);
		if(res!=null) {
			return res.get(0);
		}else {
			return null;
		}
	}

	@Override
	public ProfissionalSaudeDto buscarPorNickName(String nick_name) {
		List<ProfissionalSaude> res = profissionalSaudeRepository.findByNickName(nick_name);
		if(res.size()>0) {
			List<Medico> med = medicoRepository.findByNickName(nick_name);
			if(med.size()>0) {
				return ProfissionalSaudeDto.toDto(res.get(0), 0, med.get(0).getCrm());
			}
			List<Enfermeiro> enf = enfermeiroRepository.findByNickName(nick_name);
			if(enf.size()>0) {
				return ProfissionalSaudeDto.toDto(res.get(0), 1, enf.get(0).getCoren());
			}
		}
		return null;
	}

	@Override
	public boolean validarProf(String nick_name) {
		List<ProfissionalSaude> res = profissionalSaudeRepository.findByNickName(nick_name);
		return res.size()>0;
	}
	
	
	@Override
	public boolean existe(String codigo) {
		List<Medico> med = medicoRepository.findByCrm(codigo);
		List<Enfermeiro> enf = enfermeiroRepository.findByCoren(codigo);
		return med.size() > 0 || enf.size() > 0;
	}
	@Override
	public Medico persistirMedico(ProfissionalSaudeDto prof) {
		profissionalSaudeRepository.save(prof.toProfissionalSaude());
		return medicoRepository.save(prof.toMedico());
		
	}

	@Override
	public Enfermeiro persistirEnfermeiro(ProfissionalSaudeDto prof) {
		profissionalSaudeRepository.save(prof.toProfissionalSaude());
		return enfermeiroRepository.save(prof.toEnfermeiro());
	}

}

package com.protocolodigitalsepse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.AvEnfOp;
import com.protocolodigitalsepse.api.entities.AvMedOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoMedico;
import com.protocolodigitalsepse.api.entities.Conduta;
import com.protocolodigitalsepse.api.repositories.AvMedOpRepository;
import com.protocolodigitalsepse.api.repositories.AvaliacaoMedicoRepository;
import com.protocolodigitalsepse.api.services.AvaliacaoMedicoService;
@Service
public class AvaliacaoMedicoServiceImpl implements AvaliacaoMedicoService{
	@Autowired
	AvaliacaoMedicoRepository avaliacaoMedicoRepository;
	@Autowired
	AvMedOpRepository avMedOpRepository;
	@Override
	public AvaliacaoMedico persistir(AvaliacaoMedico avaliacaoMedico) {
		return avaliacaoMedicoRepository.save(avaliacaoMedico);
		
	}

	@Override
	public AvMedOp persistirOperacao(AvMedOp avMedOp) {
		return avMedOpRepository.save(avMedOp);
		
	}

	@Override
	public List<AvMedOp> buscarOperacoesDeAvaliacaoMedico(int id_av) {
		return null;
	}

	@Override
	public List<Conduta> buscarCondutasDeAvaliacaoMedico(int id_av) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

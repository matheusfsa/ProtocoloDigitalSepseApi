package com.protocolodigitalsepse.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.AvEnfOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoEnfermeiro;
import com.protocolodigitalsepse.api.repositories.AvEnfOpRepository;
import com.protocolodigitalsepse.api.repositories.AvaliacaoEnfemeiroRepository;
import com.protocolodigitalsepse.api.services.AvaliacaoEnfermeiroService;
@Service
public class AvaliacaoEnfermeiroServiceImpl implements AvaliacaoEnfermeiroService{
	@Autowired
	AvaliacaoEnfemeiroRepository avaliacaoEnfemeiroRepository;
	@Autowired
	AvEnfOpRepository avEnfOpRepository;
	
	@Override
	public AvaliacaoEnfermeiro persistir(AvaliacaoEnfermeiro avaliacaoEnfermeiro) {
		// TODO Auto-generated method stub
		return this.avaliacaoEnfemeiroRepository.save(avaliacaoEnfermeiro);
	}
	@Override
	public AvEnfOp persistirOperacao(AvEnfOp avEnfOp) {
		// TODO Auto-generated method stub
		return this.avEnfOpRepository.save(avEnfOp);
	}
	@Override
	public List<AvEnfOp> buscarOperacoesDeAvaliacaoEnfermeiro(int id_av) {
		return this.avEnfOpRepository.findByAvEnfOpIdIdAv(id_av);
	}
	
}

package com.protocolodigitalsepse.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.AvEnfOp;
import com.protocolodigitalsepse.api.entities.AvMedOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoMedico;
import com.protocolodigitalsepse.api.entities.Conduta;


public interface AvaliacaoMedicoService {
	AvaliacaoMedico persistir(AvaliacaoMedico avaliacaoMedico);
	AvMedOp persistirOperacao(AvMedOp avMedOp);
	List<AvMedOp> buscarOperacoesDeAvaliacaoMedico(int id_av);
	List<Conduta> buscarCondutasDeAvaliacaoMedico(int id_av);
}
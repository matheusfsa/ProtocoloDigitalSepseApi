package com.protocolodigitalsepse.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.AvEnfOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoEnfermeiro;


public interface AvaliacaoEnfermeiroService {
	AvaliacaoEnfermeiro persistir(AvaliacaoEnfermeiro avaliacaoEnfermeiro);
	List<AvEnfOp> buscarOperacoesDeAvaliacaoEnfermeiro(int id_av);

}

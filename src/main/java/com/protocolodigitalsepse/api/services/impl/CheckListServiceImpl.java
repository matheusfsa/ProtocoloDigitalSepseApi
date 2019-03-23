package com.protocolodigitalsepse.api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Operacao;
import com.protocolodigitalsepse.api.repositories.CheckListRepository;
import com.protocolodigitalsepse.api.repositories.OperacaoRepository;
import com.protocolodigitalsepse.api.services.CheckListService;
@Service
public class CheckListServiceImpl implements CheckListService{
	private static final Logger log = LoggerFactory.getLogger(CheckListServiceImpl.class);
	@Autowired
	CheckListRepository checkListRepository;
	@Autowired
	OperacaoRepository operacaoRepository;
	@Override
	public CheckList persistir(CheckList checkList) {
		return this.checkListRepository.save(checkList);
	}
	@Override
	public Operacao persistirOperacao(Operacao operacao) {
		log.info("Inserindo {}", operacao.toString());
		return this.operacaoRepository.save(operacao);
	}
	@Override
	public List<CheckList> buscarCheckListsNaoFinalizados(String reg_paciente, String nick_prof){
		log.info("Buscando checklists não finalizados do profissional: " + nick_prof + " para o paciente: " + reg_paciente );
		return this.checkListRepository.findByNickProfAndRegPacienteAndDataFim(nick_prof, reg_paciente, null);
	}
	@Override
	public List<CheckList> buscarCheckListsNaoFinalizadosProf(String nick_prof){
		log.info("Buscando checklists não finalizados do profissional: " + nick_prof);
		return this.checkListRepository.findByNickProfAndDataFim(nick_prof, null);
	}
	@Override
	public List<Operacao> buscarOperacoesDeCheckList(int idchecklist){
		return this.operacaoRepository.findByOperacaoIdIdCheckList(idchecklist);
	}
}

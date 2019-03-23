package com.protocolodigitalsepse.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Operacao;
import com.protocolodigitalsepse.api.repositories.CheckListRepository;
import com.protocolodigitalsepse.api.repositories.OperacaoRepository;
import com.protocolodigitalsepse.api.services.CheckListService;
@Service
public class CheckListServiceImpl implements CheckListService{
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
		return this.operacaoRepository.save(operacao);
	}

}

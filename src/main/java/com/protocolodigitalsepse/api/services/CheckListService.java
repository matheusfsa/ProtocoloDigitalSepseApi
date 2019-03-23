package com.protocolodigitalsepse.api.services;

import java.util.List;

import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Operacao;

public interface  CheckListService {
	public CheckList persistir(CheckList checkList);

	public Operacao persistirOperacao(Operacao operacao);

	List<CheckList> buscarCheckListsNaoFinalizados(String reg_paciente, String nick_prof);

	List<Operacao> buscarOperacoesDeCheckList(int idchecklist);

	List<CheckList> buscarCheckListsNaoFinalizadosProf(String nick_prof);
	
}

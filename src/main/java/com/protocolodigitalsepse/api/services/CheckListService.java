package com.protocolodigitalsepse.api.services;

import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Operacao;

public interface  CheckListService {
	public CheckList persistir(CheckList checkList);

	public Operacao persistirOperacao(Operacao operacao);
}

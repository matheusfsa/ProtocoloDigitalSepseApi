package com.protocolodigitalsepse.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protocolodigitalsepse.api.entities.Operacao;
import com.protocolodigitalsepse.api.entities.OperacaoId;

public interface OperacaoRepository extends JpaRepository<Operacao, Long>{
	List<Operacao> findByOperacaoIdIdCheckList(int idCheckList);
	}

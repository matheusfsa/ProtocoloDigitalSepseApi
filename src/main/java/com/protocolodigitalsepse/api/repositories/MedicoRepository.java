package com.protocolodigitalsepse.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protocolodigitalsepse.api.entities.Medico;
import java.lang.String;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	List<Medico> findByNickName(String nickName);
	
	List<Medico> findByCrm(String crm);
}

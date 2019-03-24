package com.protocolodigitalsepse.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protocolodigitalsepse.api.entities.Enfermeiro;
import java.lang.String;
import java.util.List;

public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Long>{
	List<Enfermeiro> findByNickName(String nickname);
	List<Enfermeiro> findByCoren(String coren);
}

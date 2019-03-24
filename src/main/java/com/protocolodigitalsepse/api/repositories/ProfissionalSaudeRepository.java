package com.protocolodigitalsepse.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protocolodigitalsepse.api.entities.ProfissionalSaude;
import java.lang.String;
import java.util.List;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, Long> {
	List<ProfissionalSaude> findByNickName(String nickName);
	List<ProfissionalSaude> findBySenha(String senha);
	
}

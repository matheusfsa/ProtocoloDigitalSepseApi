package com.protocolodigitalsepse.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protocolodigitalsepse.api.entities.CheckList;
import java.lang.String;
import java.util.List;

public interface CheckListRepository extends JpaRepository<CheckList, Long>{
	List<CheckList> findByNickProf(String nickProf);
	List<CheckList> findByNickProfAndRegPacienteAndDataFim(String nickProf, String regPaciente, String dataFim);
	List<CheckList> findByNickProfAndDataFim(String nick_prof, Object object);
}

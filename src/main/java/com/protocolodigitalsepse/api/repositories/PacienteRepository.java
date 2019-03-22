package com.protocolodigitalsepse.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.protocolodigitalsepse.api.entities.Paciente;
import java.lang.String;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Transactional(readOnly = true)

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	List<Paciente> findAll();
	List<Paciente> findByRegistro(String registro);
}

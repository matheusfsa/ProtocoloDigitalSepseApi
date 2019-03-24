package com.protocolodigitalsepse.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protocolodigitalsepse.api.entities.AvEnfOp;

public interface AvEnfOpRepository extends JpaRepository<AvEnfOp, Long>{
		List<AvEnfOp> findByAvEnfOpIdIdAv(int id_av);
}

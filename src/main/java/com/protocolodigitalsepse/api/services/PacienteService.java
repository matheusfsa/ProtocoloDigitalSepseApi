package com.protocolodigitalsepse.api.services;

import java.util.List;
import java.util.Optional;

import com.protocolodigitalsepse.api.entities.Paciente;

public interface PacienteService {
	/**
	 * Busca e retorna um paciente dado um registro.
	 * 
	 * @param registro
	 * @return Optional<Paciente>
	 */
	Optional<Paciente> buscarPorRegistro(String registro);
	
	
	/**
	 * Busca e retorna um pacientes que irão fazer tratamento.
	 * 
	 * @param 
	 * @return List<Paciente>
	 */
	List<Paciente> buscarPacientesParaTratamento();
	
	/**
	 * Busca e retorna um pacientes que irão fazer avaliação.
	 * 
	 * @param 
	 * @return List<Paciente>
	 */
	List<Paciente> buscarPacientesParaAvaliacao();
	
	/**
	 * Busca e retorna um pacientes estão fazendo avaliação com um médico.
	 * 
	 * @param crm
	 * @return List<Paciente>
	 */
	List<Paciente> buscarPacientesAvaliacaoMed();
	
	/**
	 * Busca e retorna um pacientes estão fazendo avaliação com um enfermeiro.
	 * 
	 * @param crem
	 * @return List<Paciente>
	 */
	List<Paciente> buscarPacientesAvaliacaoEnf();
	
	/**
	 * Busca e retorna um pacientes estão fazendo tratamento com um médico.
	 * 
	 * @param crm
	 * @return List<Paciente>
	 */
	List<Paciente> buscarPacientesTratamentoProf(String nick_name);


	List<Paciente> buscarPacientesEmTratamentoComProf(String nickProf);
	
}

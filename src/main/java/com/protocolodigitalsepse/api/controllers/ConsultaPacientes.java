package com.protocolodigitalsepse.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protocolodigitalsepse.api.dtos.PacienteDto;
import com.protocolodigitalsepse.api.entities.Paciente;
import com.protocolodigitalsepse.api.response.Response;
import com.protocolodigitalsepse.api.services.PacienteService;

@RestController
@RequestMapping("/api/consulta_pacientes")
@CrossOrigin(origins = "*")
public class ConsultaPacientes {
	private static final Logger log = LoggerFactory.getLogger(ConsultaPacientes.class);
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping(value = "/buscar/{registro}")
	public ResponseEntity<Response<PacienteDto>> buscar(@PathVariable("registro") String registro){
		log.info("Buscando paciente por registro: {}", registro);
		Response<PacienteDto> response = new Response<PacienteDto>();
		Optional<Paciente> paciente = this.pacienteService.buscarPorRegistro(registro);
		if(!paciente.isPresent()) {
			response.getErrors().add("Paciente com registro " + registro + " não encontrado.");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(this.converterPacienteDto(paciente.get()));
		return ResponseEntity.ok(response);
		
	}
	@GetMapping(value = "/tratamento/{nick_prof}")
	public ResponseEntity<Response<List<PacienteDto>>> buscar_em_tratamento(@PathVariable("nick_prof") String nick_prof ){
		log.info("Buscando pacientes que estão em tratamento com o profissional {}", nick_prof);
		Response<List<PacienteDto>> response = new Response<List<PacienteDto>>();
		List<Paciente> pacientes = this.pacienteService.buscarPacientesEmTratamentoComProf(nick_prof);
		if(pacientes.size() == 0) {
			response.getErrors().add("Erro na consulta");
			return ResponseEntity.badRequest().body(response);
		}
		List<PacienteDto> pacientesDto = new ArrayList<PacienteDto>();
		for (Paciente paciente : pacientes) {
			pacientesDto.add(this.converterPacienteDto(paciente));
		}
		response.setData(pacientesDto);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/paraTratamento")
	public ResponseEntity<Response<List<PacienteDto>>> buscar_para_tratamento(){
		log.info("Buscando paciente para tratamento");
		Response<List<PacienteDto>> response = new Response<List<PacienteDto>>();
		List<Paciente> pacientes = this.pacienteService.buscarPacientesParaTratamento();
		if(pacientes.size() == 0) {
			response.getErrors().add("Erro na consulta");
			return ResponseEntity.badRequest().body(response);
		}
		List<PacienteDto> pacientesDto = new ArrayList<PacienteDto>();
		for (Paciente paciente : pacientes) {
			pacientesDto.add(this.converterPacienteDto(paciente));
		}
		response.setData(pacientesDto);
		return ResponseEntity.ok(response);
		
	}
	@GetMapping(value = "/avaliacaoEnf")
	public ResponseEntity<Response<List<PacienteDto>>> buscar_para_avaliacao_enf(){
		log.info("Buscando paciente para avaliação da enfermagem");
		Response<List<PacienteDto>> response = new Response<List<PacienteDto>>();
		List<Paciente> pacientes = this.pacienteService.buscarPacientesAvaliacaoEnf();
		log.info("{}", pacientes);
		if(pacientes.size() == 0) {
			response.getErrors().add("Pacientes para tratamento não foram encontrados.");
			return ResponseEntity.badRequest().body(response);
		}
		List<PacienteDto> pacientesDto = new ArrayList<PacienteDto>();
		for (Paciente paciente : pacientes) {
			pacientesDto.add(this.converterPacienteDto(paciente));
		}
		response.setData(pacientesDto);
		return ResponseEntity.ok(response);
		
	}
	@GetMapping(value = "/avaliacaoMed")
	public ResponseEntity<Response<List<PacienteDto>>> buscar_para_avaliacao_Med(){
		Response<List<PacienteDto>> response = new Response<List<PacienteDto>>();
		List<Paciente> pacientes = this.pacienteService.buscarPacientesAvaliacaoMed();
		if(pacientes.size() == 0) {
			response.getErrors().add("Pacientes para tratamento não foram encontrados.");
			return ResponseEntity.badRequest().body(response);
		}
		List<PacienteDto> pacientesDto = new ArrayList<PacienteDto>();
		for (Paciente paciente : pacientes) {
			pacientesDto.add(this.converterPacienteDto(paciente));
		}
		response.setData(pacientesDto);
		return ResponseEntity.ok(response);
		
	}
	@PostMapping(value="/atualizar")
	private ResponseEntity<Response<PacienteDto>> atualizar_paciente(@RequestBody PacienteDto pacienteDto){
		Response<PacienteDto> response = new Response<PacienteDto>();
		Optional<Paciente> paciente_res = pacienteService.buscarPorRegistro(pacienteDto.getRegistro());
		Paciente paciente;
		if(paciente_res.isPresent()) {
			 	paciente = pacienteService.persistir(pacienteDto.toPaciente());
			 	response.setData(converterPacienteDto(paciente));
				return ResponseEntity.ok(response);
		}else {
			response.getErrors().add("Pacientes não existe.");
			return ResponseEntity.badRequest().body(response);
		}
	}
	private PacienteDto converterPacienteDto(Paciente paciente) {
		PacienteDto pacienteDto = new PacienteDto();
		pacienteDto.setNome(paciente.getNome());
		pacienteDto.setSobrenome(paciente.getSobrenome());
		pacienteDto.setRegistro(paciente.getRegistro());
		pacienteDto.setData_nascimento(paciente.getData_nascimento().toString());
		pacienteDto.setSexo(paciente.getSexo());
		pacienteDto.setEtapa(paciente.getEtapa());
		if(paciente.getGrupo_de_risco() == null) 
			pacienteDto.setGrupo_de_risco(null);
		else if(paciente.getGrupo_de_risco())
			pacienteDto.setGrupo_de_risco("1");
		else
			pacienteDto.setGrupo_de_risco("0");
		return pacienteDto;
	}
	
}

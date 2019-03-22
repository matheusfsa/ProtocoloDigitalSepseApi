package com.protocolodigitalsepse.api.controllers;

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
	
	@GetMapping(value = "/{registro}")
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
	private PacienteDto converterPacienteDto(Paciente paciente) {
		PacienteDto pacienteDto = new PacienteDto();
		pacienteDto.setNome(paciente.getNome());
		pacienteDto.setSobrenome(paciente.getSobrenome());
		pacienteDto.setRegistro(paciente.getRegistro());
		pacienteDto.setData_nascimento(paciente.getData_nascimento().toString());
		paciente.getSexoOpt().ifPresent(
				sexo -> pacienteDto.setSexo(Optional.of(sexo)));
		paciente.getGrupo_de_riscoOpt().ifPresent(
				grupo_de_risco-> pacienteDto.setSexo(Optional.of(grupo_de_risco.toString())));
		return pacienteDto;
	}
	
}

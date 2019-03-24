package com.protocolodigitalsepse.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protocolodigitalsepse.api.dtos.ProfissionalSaudeDto;
import com.protocolodigitalsepse.api.response.Response;
import com.protocolodigitalsepse.api.services.ProfissionalSaudeService;

@RestController
@RequestMapping("/api/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {
	private static final Logger log = LoggerFactory.getLogger(ProfissionalController.class);
	@Autowired
	ProfissionalSaudeService profissionalSaudeService;
	@PostMapping("/cadastrar")
	public ResponseEntity<Response<ProfissionalSaudeDto>> cadastrar(@RequestBody ProfissionalSaudeDto profissionalSaudeDto){
		Response<ProfissionalSaudeDto> response = new Response<ProfissionalSaudeDto>();
		log.info("nick_name existe {}", profissionalSaudeService.existeNick(profissionalSaudeDto.getNick_name()));
		if(profissionalSaudeService.existeNick(profissionalSaudeDto.getNick_name())) {
			response.getErrors().add("Nick name já existe");
			return ResponseEntity.badRequest().body(response);
		}else if(profissionalSaudeService.existe(profissionalSaudeDto.getCodigo())) {
			response.getErrors().add("O Profissional  já está cadastrado");
			return ResponseEntity.badRequest().body(response);
		}else {
			if(profissionalSaudeDto.getTipo() == 0) {
				if(profissionalSaudeService.persistirMedico(profissionalSaudeDto) == null) {
					response.getErrors().add("Falha no cadastro do médico");
					return ResponseEntity.badRequest().body(response);
				}
			}else {
				if(profissionalSaudeService.persistirEnfermeiro(profissionalSaudeDto) == null) {
					response.getErrors().add("Falha no cadastro do enfermeiro");
					return ResponseEntity.badRequest().body(response);
				}
			}
		}
		response.setData(profissionalSaudeDto);
		return ResponseEntity.ok(response);
	}
	@PostMapping("/login")
	public ResponseEntity<Response<ProfissionalSaudeDto>> login(@RequestBody ProfissionalSaudeDto profissionalSaudeDto){
		Response<ProfissionalSaudeDto> response = new Response<ProfissionalSaudeDto>();
		if(profissionalSaudeService.validarProf(profissionalSaudeDto.getNick_name(), profissionalSaudeDto.getSenha())) {
			profissionalSaudeDto = profissionalSaudeService.buscarPorNickName(profissionalSaudeDto.getNick_name());
			response.setData(profissionalSaudeDto);
			return ResponseEntity.ok(response);
		}else{
			response.getErrors().add("O profissional não está cadastrado");
			return ResponseEntity.badRequest().body(response);
		}
	}
}

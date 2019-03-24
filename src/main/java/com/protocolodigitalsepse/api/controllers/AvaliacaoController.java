package com.protocolodigitalsepse.api.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protocolodigitalsepse.api.dtos.AvEnfOpDto;
import com.protocolodigitalsepse.api.dtos.AvMedOpDto;
import com.protocolodigitalsepse.api.dtos.AvaliacaoEnfermeiroDto;
import com.protocolodigitalsepse.api.dtos.AvaliacaoMedicoDto;
import com.protocolodigitalsepse.api.dtos.InsercaoAvaliacaoEnfermeiroDto;
import com.protocolodigitalsepse.api.dtos.InsercaoAvaliacaoMedicoDto;
import com.protocolodigitalsepse.api.dtos.OperacaoDto;
import com.protocolodigitalsepse.api.entities.AvEnfOp;
import com.protocolodigitalsepse.api.entities.AvMedOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoEnfermeiro;
import com.protocolodigitalsepse.api.entities.AvaliacaoMedico;
import com.protocolodigitalsepse.api.entities.Operacao;
import com.protocolodigitalsepse.api.response.Response;
import com.protocolodigitalsepse.api.services.AvaliacaoEnfermeiroService;
import com.protocolodigitalsepse.api.services.AvaliacaoMedicoService;

@RestController
@RequestMapping("/api/avaliacao")
@CrossOrigin(origins = "*")
public class AvaliacaoController {
	private static final Logger log = LoggerFactory.getLogger(AvaliacaoController.class);
	@Autowired
	AvaliacaoEnfermeiroService avaliacaoEnfermeiroService;
	@Autowired
	AvaliacaoMedicoService avaliacaoMedicoService;
	
	@PostMapping("/criarAvaliacaoEnfermeiro")
	public ResponseEntity<Response<AvaliacaoEnfermeiroDto>> criarAvaliacaoEnfermeiro(@RequestBody InsercaoAvaliacaoEnfermeiroDto insercaoAvaliacaoEnfermeiroDto){
		Response<AvaliacaoEnfermeiroDto> response = new Response<AvaliacaoEnfermeiroDto>();
		AvaliacaoEnfermeiro AvaliacaoEnfermeiro = avaliacaoEnfermeiroService.persistir(insercaoAvaliacaoEnfermeiroDtoToAvaliacaoEnfermeiro(insercaoAvaliacaoEnfermeiroDto)); 
		if(AvaliacaoEnfermeiro == null) {
			response.getErrors().add("Erro na inserção do AvaliacaoEnfermeiro");
			return ResponseEntity.badRequest().body(response);
		}
		ArrayList<AvEnfOp> ops = operacoesEnf(AvaliacaoEnfermeiro.getId());
		for (AvEnfOp operacao : ops) {
			if(avaliacaoEnfermeiroService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na inserção da operação " + operacao.getOpcao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		AvaliacaoEnfermeiroDto dto = AvaliacaoEnfermeiroDto.convertToAvaliacaoEnfermeiroDto(AvaliacaoEnfermeiro, ops);
		log.info("AvaliacaoEnfermeiro {}", dto);
		response.setData(dto);
		
		return ResponseEntity.ok(response);		
		
	}
	@PostMapping("/criarAvaliacaoMedico")
	public ResponseEntity<Response<AvaliacaoMedicoDto>> criarAvaliacaoMedico(@RequestBody InsercaoAvaliacaoMedicoDto insercaoAvaliacaoMedicoDto){
		Response<AvaliacaoMedicoDto> response = new Response<AvaliacaoMedicoDto>();
		AvaliacaoMedico avaliacaoMedico = avaliacaoMedicoService.persistir(insercaoAvaliacaoMedicoDtoToAvaliacaoMedico(insercaoAvaliacaoMedicoDto)); 
		if(avaliacaoMedico == null) {
			response.getErrors().add("Erro na inserção da Avaliacao Medico");
			return ResponseEntity.badRequest().body(response);
		}
		log.info(avaliacaoMedico.toString());
		ArrayList<AvMedOp> ops = operacoesMed(avaliacaoMedico.getId());
		for (AvMedOp operacao : ops) {
			if(avaliacaoMedicoService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na inserção da operação " + operacao.getOpcao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		AvaliacaoMedicoDto dto = AvaliacaoMedicoDto.convertToAvaliacaoMedicoDto(avaliacaoMedico, ops);
		log.info("AvaliacaoMedico {}", dto);
		response.setData(dto);
		
		return ResponseEntity.ok(response);		
		
	}

	@PostMapping("/atualizarAvaliacaoEnfermeiro")
	public ResponseEntity<Response<AvaliacaoEnfermeiroDto>> atualizarAvaliacaoEnfermeiro(@RequestBody AvaliacaoEnfermeiroDto avaliacaoEnfermeiroDto){
		Response<AvaliacaoEnfermeiroDto> response = new Response<AvaliacaoEnfermeiroDto>();
		AvaliacaoEnfermeiro avaliacaoEnfermeiro = avaliacaoEnfermeiroService.persistir(AvaliacaoEnfermeiroDto.convertToAvaliacaoEnfermeiro(avaliacaoEnfermeiroDto)); 
		if(avaliacaoEnfermeiro == null) {
			response.getErrors().add("Erro na inserção do avaliacao Enfermeiro");
			return ResponseEntity.badRequest().body(response);
		}
		ArrayList<AvEnfOp> ops = AvEnfOpDto.convertToAvEnfOp(avaliacaoEnfermeiroDto.getOps());
		for (AvEnfOp operacao : ops) {
			if(avaliacaoEnfermeiroService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na atualização da operação " + operacao.getOpcao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		AvaliacaoEnfermeiroDto dto = AvaliacaoEnfermeiroDto.convertToAvaliacaoEnfermeiroDto(avaliacaoEnfermeiro, ops);
		log.info("AvaliacaoEnfermeiro {}", dto);
		response.setData(dto);
		
		return ResponseEntity.ok(response);		
		
	}
	@PostMapping("/atualizarAvaliacaoMedico")
	public ResponseEntity<Response<AvaliacaoMedicoDto>> atualizarAvaliacaoMedico(@RequestBody AvaliacaoMedicoDto avaliacaoMedicoDto){
		Response<AvaliacaoMedicoDto> response = new Response<AvaliacaoMedicoDto>();
		AvaliacaoMedico avaliacaoMedico = avaliacaoMedicoService.persistir(AvaliacaoMedicoDto.convertToAvaliacaoMedico(avaliacaoMedicoDto)); 
		if(avaliacaoMedico == null) {
			response.getErrors().add("Erro na inserção do avaliacao Medico");
			return ResponseEntity.badRequest().body(response);
		}
		ArrayList<AvMedOp> ops = AvMedOpDto.convertToAvMedOp(avaliacaoMedicoDto.getOps());
		for (AvMedOp operacao : ops) {
			if(avaliacaoMedicoService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na atualização da operação " + operacao.getOpcao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		AvaliacaoMedicoDto dto = AvaliacaoMedicoDto.convertToAvaliacaoMedicoDto(avaliacaoMedico, ops);
		log.info("AvaliacaoMedico {}", dto);
		response.setData(dto);
		
		return ResponseEntity.ok(response);		
		
	}
	
	
	public AvaliacaoEnfermeiro insercaoAvaliacaoEnfermeiroDtoToAvaliacaoEnfermeiro(InsercaoAvaliacaoEnfermeiroDto insercaoAvaliacaoEnfermeiroDto) {
		AvaliacaoEnfermeiro res = new AvaliacaoEnfermeiro();
		res.setCoren(insercaoAvaliacaoEnfermeiroDto.getCoren());
		res.setRegistro(insercaoAvaliacaoEnfermeiroDto.getRegistro());
		res.setResultado(0);
		return res;
	}
	public AvaliacaoMedico insercaoAvaliacaoMedicoDtoToAvaliacaoMedico(InsercaoAvaliacaoMedicoDto insercaoAvaliacaoMedicoDto) {
		AvaliacaoMedico res = new AvaliacaoMedico();
		res.setCrm(insercaoAvaliacaoMedicoDto.getCrm());
		res.setRegistro(insercaoAvaliacaoMedicoDto.getRegistro());
		res.setResultado(0);
		return res;
	}
	public ArrayList<AvEnfOp> operacoesEnf(int id){
		ArrayList<AvEnfOp> res = new ArrayList<AvEnfOp>();
		String[] tipo1 = {"Hipertemia > 37,8 graus ou hiportemia < 35 graus", "Leucocitose > 12000, leucopenia < 4000 ou desvio esquerdo > 10%", "Taquicardia > 90bpm", "Taquipneia > 20 irpm"};
		String[] tipo2 = {"Oligúrgia", "Hipotensão", "Rebaixamento do nível de consciência", "Dispneia ou dessaturação"};
		for (String string : tipo1) {
			AvEnfOp a = new AvEnfOp();
			a.setIdAv(id);
			a.setOpcao(string);
			a.setResultado(0);
			a.setTipo(1);
			res.add(a);
		}
		for (String string : tipo2) {
			AvEnfOp a = new AvEnfOp();
			a.setIdAv(id);
			a.setOpcao(string);
			a.setResultado(0);
			a.setTipo(2);
			res.add(a);
		}
		return res;
	}
	public ArrayList<AvMedOp> operacoesMed(int id){
		ArrayList<AvMedOp> res = new ArrayList<AvMedOp>();
		
		String[] tipo1 = {"Pneumonia/Epiema", "Infecção urinária", "Infecção abdominal aguda", "Menigite", "Endocardite",
				"Pele e partes moles", "Infecção de protése", "Infecção óssea/articular", "Infecção de ferida operatória",
				"Infecção de corrente sanguínea associada ao cateter", "Sem foco definido", "Outras Infecções"};
		String[] tipo2 = {"Infecção", "Sepse", "Choque Séptico", "Afastado infecção/sepse/choque séptico",
				"Sepse/ choque séptico em cuidados de fim de vida sem conduta no momento"};
		String[] tipo3 = {"Paciente não tinha disfunção orgânica, somente infecção",
				"PAS < 90 mmHg ou PAM < 65mmHg ou queda de redução de 40mmHg ou mais da PAS de base",
				"Relação PaO2//FIO2 < 300 ou necessidade O2 para manter SpO2 > 90", "Rebaixamento do nível de consciência", 
				"Creatinina > 2,0 mg/dL ou diures menor que 0,5mL/Kg/h nas últimas 2 horas", "Bilirrubina > 2mg/dL", 
				"Contagem de plaqueta < 100.000mm^3", "Lactato acima do valor de referência",
				"Coagulopatia(INR > 1,5 ou TTPA > 60 seg) )"};
		for (String string : tipo1) {
			AvMedOp a = new AvMedOp();
			a.setIdAv(id);
			a.setOpcao(string);
			a.setResultado(0);
			a.setTipo(1);
			res.add(a);
		}
		for (String string : tipo2) {
			AvMedOp a = new AvMedOp();
			a.setIdAv(id);
			a.setOpcao(string);
			a.setResultado(0);
			a.setTipo(2);
			res.add(a);
		}
		for (String string : tipo3) {
			AvMedOp a = new AvMedOp();
			a.setIdAv(id);
			a.setOpcao(string);
			a.setResultado(0);
			a.setTipo(3);
			res.add(a);
		}
		
		log.info("Res: {}", res.size());
		return res;
	}
}
package com.protocolodigitalsepse.api.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protocolodigitalsepse.api.dtos.CheckListDto;
import com.protocolodigitalsepse.api.dtos.InsercaoCheckListDto;
import com.protocolodigitalsepse.api.dtos.OperacaoDto;
import com.protocolodigitalsepse.api.dtos.PacienteDto;
import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Operacao;
import com.protocolodigitalsepse.api.entities.OperacaoId;
import com.protocolodigitalsepse.api.response.Response;
import com.protocolodigitalsepse.api.services.CheckListService;

@RestController
@RequestMapping("/api/checklist")
@CrossOrigin(origins = "*")
public class CheckListController {
	private static final Logger log = LoggerFactory.getLogger(CheckListController.class);
	@Autowired
	CheckListService checkListService;
	@PostMapping("/criarCheckList")
	public ResponseEntity<Response<CheckListDto>> criarCheckList(@RequestBody InsercaoCheckListDto insercaoCheckListDto){
		Response<CheckListDto> response = new Response<CheckListDto>();
		CheckList checkList = checkListService.persistir(insercaoCheckListDtoToCheckList(insercaoCheckListDto)); 
		if(checkList == null) {
			response.getErrors().add("Erro na inserção do checklist");
			return ResponseEntity.badRequest().body(response);
		}
		ArrayList<Operacao> ops = operacoes(checkList.getId(), insercaoCheckListDto.getPacote());
		for (Operacao operacao : ops) {
			if(checkListService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na inserção da operação " + operacao.getOperacao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		CheckListDto dto = CheckListDto.convertToCheckListDto(checkList, ops);
		log.info("Checklist {}", dto);
		response.setData(dto);
		
		return ResponseEntity.ok(response);		
		
	}

	@PostMapping("/atualizarCheckList")
	public ResponseEntity<Response<CheckListDto>> atualizarCheckList(@RequestBody CheckListDto checkListDto){
		Response<CheckListDto> response = new Response<CheckListDto>();
		CheckList checkList = checkListService.persistir(CheckListDto.convertToCheckList(checkListDto)); 
		if(checkList == null) {
			response.getErrors().add("Erro na inserção do checklist");
			return ResponseEntity.badRequest().body(response);
		}
		ArrayList<Operacao> ops = OperacaoDto.convertToOperacao(checkListDto.getOps());
		for (Operacao operacao : ops) {
			if(checkListService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na atualização da operação " + operacao.getOperacao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		CheckListDto dto = CheckListDto.convertToCheckListDto(checkList, ops);
		log.info("Checklist {}", dto);
		response.setData(dto);
		
		return ResponseEntity.ok(response);		
		
	}
	
	
	public CheckList insercaoCheckListDtoToCheckList(InsercaoCheckListDto insercaoCheckListDto) {
		CheckList res = new CheckList();
		//res.setId(checkListDto.getId());
		res.setRegPaciente(insercaoCheckListDto.getReg_paciente());
		res.setNickProf(insercaoCheckListDto.getNick_prof());
		res.setDataInicio(new Date());
		res.setDataFim(null);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			res.setDataDiag(formatter.parse(insercaoCheckListDto.getData_diag()));
		} catch (ParseException e) {
			res.setDataDiag(null);
		}
		return res;
	}
	
	public ArrayList<Operacao> operacoes(int id, int pacote){
		ArrayList<Operacao> res = new ArrayList<Operacao>();
		if(pacote == 3) {
			//Operação a
			Operacao a = new Operacao();
			a.setIdCheckList(id);
			a.setOperacao("a) Coleta de lactato sérico para avaliação do estado perfusional");
			a.setRes(0);
			a.setComentario(null);
			a.setData_hora(null);
			res.add(a);
			
			//Operação b
			Operacao b = new Operacao();
			b.setIdCheckList(id);
			b.setOperacao("b) Coleta de hemocultura e culturas dos sítios pertinentes ao foco em suspeita antes do início da antibioticoterapia");
			b.setRes(0);
			b.setComentario(null);
			b.setData_hora(null);
			res.add(b);
			
			//Operação c
			Operacao c = new Operacao();
			c.setIdCheckList(id);
			c.setOperacao("c) Início de antibióticos, de largo espectro, por via endovenosa, nas primeiras horas de tratamento");
			c.setRes(0);
			c.setComentario(null);
			c.setData_hora(null);
			res.add(c);
			
			//Operação d
			Operacao d = new Operacao();
			d.setIdCheckList(id);
			d.setOperacao("d) Reposição volêmica agressiva (30mL/kg de peso) em pacientes com hipotensão ou lactato acima de duas vezes o valor de referência");
			d.setRes(0);
			d.setComentario(null);
			d.setData_hora(null);
			res.add(d);
		}else {
			//Operação a
			Operacao a = new Operacao();
			a.setIdCheckList(id);
			a.setOperacao("a) Uso de vasopressores para manter pressão arterial média acima de 65mmHg");
			a.setRes(0);
			a.setComentario(null);
			a.setData_hora(null);
			res.add(a);
			
			//Operação b
			Operacao b = new Operacao();
			b.setIdCheckList(id);
			b.setOperacao("b) Reavaliação da volemia e perfusão tecidual");
			b.setRes(0);
			b.setComentario(null);
			b.setData_hora(null);
			res.add(b);
			
			//Operação c
			Operacao c = new Operacao();
			c.setIdCheckList(id);
			c.setOperacao("c) Reavaliação dos níveis de lactato em pacientes com hiperlactatemia inicial");
			c.setRes(0);
			c.setComentario(null);
			c.setData_hora(null);
			res.add(c);
		}
		log.info("Res: {}", res.size());
		return res;
	}
}

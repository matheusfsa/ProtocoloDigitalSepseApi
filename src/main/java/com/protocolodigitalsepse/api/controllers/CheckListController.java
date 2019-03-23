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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protocolodigitalsepse.api.dtos.CheckListDto;
import com.protocolodigitalsepse.api.dtos.OperacaoDto;
import com.protocolodigitalsepse.api.entities.CheckList;
import com.protocolodigitalsepse.api.entities.Operacao;
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
	public ResponseEntity<Response<CheckListDto>> criarCheckList(@RequestBody CheckListDto checkListDto){
		Response<CheckListDto> response = new Response<CheckListDto>();
		CheckList checkList = checkListService.persistir(dtoToCheckList(checkListDto)); 
		if(checkList == null) {
			response.getErrors().add("Erro na inserção do checklist");
			return ResponseEntity.badRequest().body(response);
		}
		ArrayList<Operacao> ops = operacoes(checkList.getId(), checkListDto.getPacote());
		for (Operacao operacao : ops) {
			if(checkListService.persistirOperacao(operacao) == null) {
					response.getErrors().add("Erro na inserção do operação " + operacao.getOperacao());
					return ResponseEntity.badRequest().body(response);
				
			}
		}
		response.setData(convertToCheckListDto(checkList, ops));
		return ResponseEntity.ok(response);		
		
	}
	public ArrayList<OperacaoDto> convertToOperacaoDto(ArrayList<Operacao> ops) {
		ArrayList<OperacaoDto> res = new ArrayList<OperacaoDto>();
		for (Operacao operacao : ops) {
			OperacaoDto o = new OperacaoDto();
			o.setComentario(operacao.getComentario());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(operacao.getData_hora() != null)
				o.setData_hora(operacao.getData_hora().toString());
			else
				o.setData_hora(null);
			o.setIdCheckList(operacao.getIdCheckList());
			o.setRes(operacao.getRes());
		}
		return res;
	}
	public CheckListDto convertToCheckListDto(CheckList checkList, ArrayList<Operacao> ops) {
		CheckListDto res = new CheckListDto();
		res.setComentario(checkList.getComentario());
		res.setData_diag(checkList.getData_diag().toString());
		if(checkList.getData_fim() != null)
			res.setData_fim(checkList.getData_fim().toString());
		else
			res.setData_fim(null);
		if(checkList.getData_inicio() != null)
			res.setData_inicio(checkList.getData_inicio().toString());
		else
			res.setData_inicio(null);
		res.setId(checkList.getId());
		res.setNick_prof(checkList.getNickProf());
		res.setOps(convertToOperacaoDto(ops));
		return res;
	}
	public CheckList dtoToCheckList(CheckListDto checkListDto) {
		CheckList res = new CheckList();
		res.setId(checkListDto.getId());
		res.setReg_paciente(checkListDto.getReg_paciente());
		res.setNickProf(checkListDto.getNick_prof());
		res.setData_inicio(new Date());
		res.setData_fim(null);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			res.setData_diag(formatter.parse(checkListDto.getData_diag()));
		} catch (ParseException e) {
			res.setData_diag(null);
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
		return res;
	}
}

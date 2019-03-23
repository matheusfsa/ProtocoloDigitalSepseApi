package com.protocolodigitalsepse.api.dtos;

import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvMedOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoMedico;
import com.protocolodigitalsepse.api.entities.Conduta;


public class AvaliacaoMedicoDto {
	private int id;
	private String crm;
	private String registro;
	private ArrayList<AvMedOpDto> ops;
	private ArrayList<CondutaDto> conds;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public ArrayList<AvMedOpDto> getOps() {
		return ops;
	}

	public void setOps(ArrayList<AvMedOpDto> ops) {
		this.ops = ops;
	}

	public ArrayList<CondutaDto> getConds() {
		return conds;
	}

	public void setConds(ArrayList<CondutaDto> conds) {
		this.conds = conds;
	}
	public static AvaliacaoMedicoDto convertToAvaliacaoMedicoDto(AvaliacaoMedico avaliacaoMedico, ArrayList<AvMedOp> ops, ArrayList<Conduta> conds) {
		AvaliacaoMedicoDto res = new AvaliacaoMedicoDto();
		res.setCrm(avaliacaoMedico.getCrm());
		res.setId(avaliacaoMedico.getId());
		res.setRegistro(avaliacaoMedico.getRegistro());
		res.setOps(AvMedOpDto.convertToAvMedOpDto(ops));
		res.setConds(CondutaDto.convertToCondutaDto(conds));
		return res;
	}
	public static AvaliacaoMedico convertToAvaliacaoMedico(AvaliacaoMedicoDto avaliacaoMedicoDto){
		
		AvaliacaoMedico res = new AvaliacaoMedico();
		res.setCrm(avaliacaoMedicoDto.getCrm());
		res.setId(avaliacaoMedicoDto.getId());
		res.setRegistro(avaliacaoMedicoDto.getRegistro());
		return res;
	}
}


package com.protocolodigitalsepse.api.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.protocolodigitalsepse.api.entities.AvMedOp;
import com.protocolodigitalsepse.api.entities.AvaliacaoMedico;
import com.protocolodigitalsepse.api.entities.Conduta;


public class AvaliacaoMedicoDto {
	private int id;
	private String crm;
	private String registro;
	private String data;
	private ArrayList<AvMedOpDto> ops;
	//private ArrayList<CondutaDto> conds;
	
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
	/**
	public ArrayList<CondutaDto> getConds() {
		return conds;
	}

	public void setConds(ArrayList<CondutaDto> conds) {
		this.conds = conds;
	}
	**/
	public static AvaliacaoMedicoDto convertToAvaliacaoMedicoDto(AvaliacaoMedico avaliacaoMedico, ArrayList<AvMedOp> ops) {
		AvaliacaoMedicoDto res = new AvaliacaoMedicoDto();
		res.setCrm(avaliacaoMedico.getCrm());
		res.setId(avaliacaoMedico.getId());
		res.setRegistro(avaliacaoMedico.getRegistro());
		res.setOps(AvMedOpDto.convertToAvMedOpDto(ops));
		if(avaliacaoMedico.getData()!=null)
			res.setData(avaliacaoMedico.getData().toString());
		else
			res.setData(null);
		//res.setConds(CondutaDto.convertToCondutaDto(conds));
		return res;
	}
	public static AvaliacaoMedico convertToAvaliacaoMedico(AvaliacaoMedicoDto avaliacaoMedicoDto){
		
		AvaliacaoMedico res = new AvaliacaoMedico();
		res.setCrm(avaliacaoMedicoDto.getCrm());
		res.setId(avaliacaoMedicoDto.getId());
		res.setRegistro(avaliacaoMedicoDto.getRegistro());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(avaliacaoMedicoDto.getData() != null)
			try {
				res.setData(formatter.parse(avaliacaoMedicoDto.getData().toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			res.setData(null);
		return res;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}


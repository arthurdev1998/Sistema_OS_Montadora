package com.arthur.montadora.domain;

import java.time.LocalDateTime;

import com.arthur.montadora.domain.enums.Prioridades;
import com.arthur.montadora.domain.enums.Status;

public class OrdemDeServico {
	
	private Integer id;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataFechamento;
	private Integer  prioridade;
	private Integer status;
	private Tecnico tecnico;
	private Cliente cliente;
	
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}



	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}



	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}



	public Prioridades getPrioridade() {
		return Prioridades.PrioridadesToEnum(this.prioridade);
	}



	public void setPrioridade(Prioridades prioridade) {
		this.prioridade = prioridade.getCod();
	}



	public Status getStatus() {
		return Status.statusToEnum(this.status);
	}



	public void setStatus(Status status) {
		this.status = status.getCod();
	}



	public Tecnico getTecnico() {
		return tecnico;
	}



	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public OrdemDeServico() {
		this.setDataAbertura(LocalDateTime.now());
		this.setStatus(Status.ABERTO);
		this.setPrioridade(Prioridades.BAIXA); 
	}

	public OrdemDeServico(Integer id,  LocalDateTime dataFechamento, Prioridades prioridade,
			Status status, Tecnico tecnico, Cliente cliente) {
		
		
		this.id = id;
		this.setDataAbertura(LocalDateTime.now());
		this.dataFechamento = dataFechamento;
		this.prioridade = (prioridade == null )? 0: prioridade.getCod();
		this.status = (status == null)? 0: status.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
	}
	
	

}

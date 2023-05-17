package com.arthur.montadora.domain;

import java.io.Serializable;
import java.time.LocalDateTime;


import com.arthur.montadora.domain.enums.Prioridades;
import com.arthur.montadora.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="ORDEM_SERVICO")
@Entity
public class OrdemDeServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	private Integer  prioridade;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="TECNICO_ID")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID")
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

	public OrdemDeServico(Integer id,  Prioridades prioridade,
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

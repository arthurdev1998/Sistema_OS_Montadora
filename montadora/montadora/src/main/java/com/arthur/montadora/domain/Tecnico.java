package com.arthur.montadora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TECNICO")
public class Tecnico extends Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
       
    @JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<OrdemDeServico> ordemservico  = new ArrayList<>();
	
	
	
	public List<OrdemDeServico> getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(List<OrdemDeServico> ordemservico) {
		this.ordemservico = ordemservico;
	}

	public Tecnico() {
		super();
	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}
	
	
	
}

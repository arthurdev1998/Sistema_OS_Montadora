package com.arthur.montadora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="CLIENTE")
@Entity
public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	@OneToMany(mappedBy = "cliente")
	private List<OrdemDeServico> ordemservico = new ArrayList<>() ;
	
	
	
	
	
	public List<OrdemDeServico> getOrdemservico() {
		return ordemservico;
	}

	public void setOrdemservico(List<OrdemDeServico> ordemservico) {
		this.ordemservico = ordemservico;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
		// TODO Auto-generated constructor stub
	}

	
}

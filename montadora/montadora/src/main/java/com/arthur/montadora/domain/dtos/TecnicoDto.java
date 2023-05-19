package com.arthur.montadora.domain.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.arthur.montadora.domain.Tecnico;

import jakarta.annotation.Nonnull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TecnicoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public TecnicoDto() {

	}
	public TecnicoDto(Tecnico tecnico) {
		
		this.id = tecnico.getId();
		this.nome = tecnico.getNome();
		this.cpf = tecnico.getCpf();
		this.telefone = tecnico.getTelefone();
	}
	
	
	

}

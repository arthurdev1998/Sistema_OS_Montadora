package com.arthur.montadora.domain.enums;

public enum Status {
ABERTO(0,"Aberto"), ANDAMENTO(1,"Andamento"), FECHADO(2,"Fechado");
	
	private Integer cod;
	private String descricao;
	
	private Status() {}
	
	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Status statusToEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("código inválido");
	}
	
	
}

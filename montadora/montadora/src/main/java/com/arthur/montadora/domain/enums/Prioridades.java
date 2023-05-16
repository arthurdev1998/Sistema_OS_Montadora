package com.arthur.montadora.domain.enums;

public enum Prioridades {
	ALTA(0,"Alta"), MEDIA(1,"Media"), BAIXA(2,"Baixa");
	
	private Integer cod;
	private String descricao;
	
	
	
	private Prioridades() {
	}


	private Prioridades(Integer cod, String descricao) {
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
	
	
	public static Prioridades PrioridadesToEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Prioridades x : Prioridades.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido");
	}

}

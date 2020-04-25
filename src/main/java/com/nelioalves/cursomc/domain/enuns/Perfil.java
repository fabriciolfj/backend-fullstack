package com.nelioalves.cursomc.domain.enuns;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private Integer tipo;
	private String descricao;
	
	private Perfil(Integer tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Perfil est : Perfil.values()) {
			if(est.getTipo().equals(cod)) {
				return est;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

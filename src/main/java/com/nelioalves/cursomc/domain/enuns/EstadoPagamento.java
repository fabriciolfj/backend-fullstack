package com.nelioalves.cursomc.domain.enuns;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private Integer tipo;
	private String descricao;
	
	private EstadoPagamento(Integer tipo, String descricao) {
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
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento est : EstadoPagamento.values()) {
			if(est.getTipo().equals(cod)) {
				return est;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

package com.nelioalves.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nelioalves.cursomc.domain.enuns.EstadoPagamento;

@Entity
@DiscriminatorValue(value = "1")
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{

	private static final long serialVersionUID = 2384223937710195410L;
	
	@Column(name = "NUMERODEPARCELAS")
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	@Override
	public String toString() {
		return "PagamentoComCartao [numeroDeParcelas=" + numeroDeParcelas + ", getId()=" + getId() + ", getEstado()="
				+ getEstado() + ", getPedido()=" + getPedido() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}

	
}

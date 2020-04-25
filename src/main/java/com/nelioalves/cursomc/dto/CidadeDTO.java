package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 733816530707902422L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String nome;

	public CidadeDTO(Integer id, @NotEmpty(message = "Preenchimento obrigatório.") String nome) {
		this.id = id;
		this.nome = nome;
	}

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

}

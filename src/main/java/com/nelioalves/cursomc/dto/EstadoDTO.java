package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 496830630713558335L;

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	public EstadoDTO(Long id, @NotEmpty(message = "Preenchimento obrigatório") String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}

package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.dto.CidadeDTO;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<CidadeDTO> findAllCityState(Integer idEstado) {
		List<Cidade> cidades = repository.findCidades(idEstado);
		
		if(cidades.isEmpty()) {
			throw new ObjectNotFoundException("Nenhuma cidade encontrada.");
		}
		
		return converterListCidadeToCidadeDTO(cidades);
	}
	
	private List<CidadeDTO> converterListCidadeToCidadeDTO(List<Cidade> cidades){
		List<CidadeDTO> objDto = cidades.stream().map(c -> converterCidadeDtoToCidade(c)).collect(Collectors.toList());
		return objDto;
	}
	
	private CidadeDTO converterCidadeDtoToCidade(Cidade cidade) {
		return new CidadeDTO(cidade.getId(), cidade.getNome());
	}
}

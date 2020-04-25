package com.nelioalves.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.dto.CidadeDTO;
import com.nelioalves.cursomc.services.CidadeService;

@RestController
@RequestMapping(value = "/estados")
@CrossOrigin(origins = "*")
public class EstadoResources {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/{estado_id}/cidades")
	public ResponseEntity<List<CidadeDTO>> getCidades(@PathVariable("estado_id") Integer idEstado){
		List<CidadeDTO> cidades = cidadeService.findAllCityState(idEstado);
		return ResponseEntity.ok().body(cidades);
	}
}

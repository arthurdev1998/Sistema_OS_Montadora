package com.arthur.montadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.montadora.domain.Tecnico;
import com.arthur.montadora.domain.dtos.TecnicoDto;
import com.arthur.montadora.services.TecnicoService;

@RestController
@RequestMapping(value="/api/montadora")
public class TecnicoController {
	
	@Autowired
	private TecnicoService tecnicoservice;

	@GetMapping(value="/{Id}")
	
	public ResponseEntity<TecnicoDto> FindTecnicoById(@PathVariable(value="Id")Integer id) {
	var obj =  tecnicoservice.getByIdTecnico(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDto>> FindAllTecnico(){
		var obj =  tecnicoservice.getAllTecnicos();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDto> CreateTecnico(@RequestBody Tecnico tecnico){
		var obj = tecnicoservice.CreateTecnico(tecnico);
		return ResponseEntity.ok().body(obj);
	}
}

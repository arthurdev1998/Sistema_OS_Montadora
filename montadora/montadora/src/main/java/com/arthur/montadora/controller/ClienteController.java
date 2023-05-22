package com.arthur.montadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.montadora.domain.Cliente;
import com.arthur.montadora.domain.dtos.ClienteDto;
import com.arthur.montadora.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteservice;
	
	@GetMapping(value="/{Id}")
	public ResponseEntity<ClienteDto> GetClientById(@PathVariable(value="Id") Integer id){
		var obj = clienteservice.GetClient(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> GetAllClient(){
		var obj = clienteservice.GetAllClient();
		return ResponseEntity.ok().body(obj);
	}
 	
	@PostMapping
	public ResponseEntity<ClienteDto> createClient(@Valid @RequestBody  ClienteDto cliente) {
	var obj =  clienteservice.CreateCliente(cliente);
	return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<ClienteDto> updateClient(@Valid @RequestBody  ClienteDto cliente){
	var obj = clienteservice.updateCliente(cliente);
	return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/{Id}")
	public ResponseEntity<?> deleteClient(@PathVariable(value="Id")Integer id){
		clienteservice.deleteClient(id);	
		return ResponseEntity.noContent().build();
	}
}

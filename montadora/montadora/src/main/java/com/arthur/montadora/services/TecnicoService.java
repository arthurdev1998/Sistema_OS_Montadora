package com.arthur.montadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arthur.montadora.domain.Tecnico;
import com.arthur.montadora.domain.dtos.TecnicoDto;
import com.arthur.montadora.exceptions.BadRequestException;
import com.arthur.montadora.exceptions.ResourcesNotFoundException;
import com.arthur.montadora.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicorepository;
	
	public TecnicoDto getByIdTecnico(Integer id) {
		var entity =  tecnicorepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Ops, nao encontramos"));
		return new TecnicoDto(entity);
	}
	
	public List<TecnicoDto> getAllTecnicos(){
		var listdto = tecnicorepository.findAll();
		var entity = listdto.stream().map(x -> new TecnicoDto(x)).toList();
		return entity;
		
	}
	
	public TecnicoDto CreateTecnico(Tecnico tecnico) {
		if (FindCpf(tecnico)!= null) throw new BadRequestException("Cpf já cadastrado");
		
			
		 
		var obj = tecnicorepository.save(tecnico);
		return new TecnicoDto(obj);
	}

	public Tecnico FindCpf(Tecnico tecnico) {
		return  tecnicorepository.findCpf(tecnico.getCpf());
		
	}
	
}

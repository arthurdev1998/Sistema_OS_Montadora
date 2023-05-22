package com.arthur.montadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arthur.montadora.domain.OrdemDeServico;
import com.arthur.montadora.domain.Tecnico;
import com.arthur.montadora.domain.dtos.TecnicoDto;
import com.arthur.montadora.domain.enums.Prioridades;
import com.arthur.montadora.domain.enums.Status;
import com.arthur.montadora.exceptions.ResourcesNotFoundException;
import com.arthur.montadora.repositories.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicorepository;

	public TecnicoDto getByIdTecnico(Integer id) {
		var entity = tecnicorepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Ops, nao encontramos"));
		return new TecnicoDto(entity);
	}

	public List<TecnicoDto> getAllTecnicos() {
		var listdto = tecnicorepository.findAll();
		var entity = listdto.stream().map(x -> new TecnicoDto(x)).toList();
		return entity;

	}

	public TecnicoDto CreateTecnico(Tecnico tecnico) {
		if (FindCpf(tecnico) != null)
			throw new ResourcesNotFoundException("Cpf já cadastrado");

		var obj = tecnicorepository.save(tecnico);
		return new TecnicoDto(obj);
	}

	public Tecnico FindCpf(Tecnico tecnico) {

		var obj = tecnicorepository.findCpf(tecnico.getCpf());

		if (obj != null) {
			return obj;

		} else {
			return null;
		}
	}

	public TecnicoDto update(Tecnico tecnico) {

		var obj = tecnicorepository.findById(tecnico.getId())
				.orElseThrow(() -> new ResourcesNotFoundException("Tecnico nao encontrado"));

		if (FindCpf(tecnico) != null)
			throw new ResourcesNotFoundException("Cpf já cadastrado");

		var entity = tecnicorepository.save(obj);

		return new TecnicoDto(entity);
	}

	public void delete(Integer id) {
		var obj = tecnicorepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Tecnico nao encontrado"));

		List<OrdemDeServico> entity = obj.getOrdemservico();
		for (OrdemDeServico x : entity) {
			if (x.getStatus() != Status.FECHADO)
				throw new ResourcesNotFoundException(
						"Não é possível excluir um tecnico enquanto ele ainda estiver em uma ordem de Serviço");
		}

		tecnicorepository.deleteById(id);

	}

}

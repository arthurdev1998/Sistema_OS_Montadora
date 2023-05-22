package com.arthur.montadora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.montadora.domain.Cliente;
import com.arthur.montadora.domain.OrdemDeServico;
import com.arthur.montadora.domain.dtos.ClienteDto;
import com.arthur.montadora.domain.enums.Status;
import com.arthur.montadora.exceptions.ResourcesNotFoundException;
import com.arthur.montadora.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienterepository;
	
	
	public ClienteDto GetClient(Integer id) {
		var entity = clienterepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Cliente não encontrado"));
		return new ClienteDto(entity);
	}
	
	public List<ClienteDto> GetAllClient(){
		var entity = clienterepository.findAll();
		return entity.stream().map((x)->new ClienteDto(x)).toList();
	}
	
	
	public ClienteDto CreateCliente(ClienteDto cliente) {
	if(FindByCpf(cliente) != null) throw new ResourcesNotFoundException("Cliente já cadastrado");
	var obj =  clienterepository.save(new Cliente(null, cliente.getNome(),cliente.getCpf(),cliente.getTelefone()));
	return new ClienteDto(obj);	
	}
	
	public ClienteDto updateCliente(ClienteDto cliente) {
		
		var entity = clienterepository.findById(cliente.getId()).orElseThrow(()-> new ResourcesNotFoundException("Cliente nao encontrado"));
		entity.setId(cliente.getId());
		entity.setNome(cliente.getNome());
		entity.setCpf(cliente.getCpf());
		entity.setTelefone(cliente.getTelefone());
		
		return new ClienteDto(clienterepository.save(entity));
	
		
	}
	
	public void deleteClient(Integer id) {
	var obj = clienterepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Cliente não encontrado"));
	List<OrdemDeServico> ListOrdem = obj.getOrdemservico();
	
	for(OrdemDeServico itens : ListOrdem) {
		if(itens.getStatus()!= Status.FECHADO) {
			throw new ResourcesNotFoundException("Não é possível excluir o cliente enquanto ainda houver uma ordem de serviço em seu nome");
		}		
	}
	
	clienterepository.deleteById(id);
	
		
	}
	
	
	
	public Cliente FindByCpf(ClienteDto cliente) {
		var obj = clienterepository.findByCpf(cliente.getCpf());
		if( obj != null) {
			return obj;
		}
		else {
			return null;
		}
	}
	
	
}
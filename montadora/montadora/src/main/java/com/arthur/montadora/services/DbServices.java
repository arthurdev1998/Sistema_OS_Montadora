package com.arthur.montadora.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.arthur.montadora.domain.Cliente;
import com.arthur.montadora.domain.OrdemDeServico;
import com.arthur.montadora.domain.Tecnico;
import com.arthur.montadora.domain.enums.Prioridades;
import com.arthur.montadora.domain.enums.Status;
import com.arthur.montadora.repositories.ClienteRepository;
import com.arthur.montadora.repositories.OrdemdeServicoRepository;
import com.arthur.montadora.repositories.TecnicoRepository;

@Service
public class DbServices {
	
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private TecnicoRepository tecnicorepotitory;
	@Autowired
	private OrdemdeServicoRepository ordemdeservico;
	
	
	
	@Bean
	public void instanciaDB() {
		
		Tecnico Tecnico01 = new Tecnico(null, "Arthur Mendes", "144.785.300-84", "(81)98798-9871");
		Cliente Cliente01 = new Cliente(null, "Michael Cavalcanti", "598.508.200-80", "(81)98888-7777");
		OrdemDeServico OS01 = new OrdemDeServico(null,Prioridades.ALTA, Status.ANDAMENTO , Tecnico01,Cliente01);
		
		tecnicorepotitory.saveAll(Arrays.asList(Tecnico01));
		clienterepository.saveAll(Arrays.asList(Cliente01));
		ordemdeservico.saveAll(Arrays.asList(OS01));
		
	}

}

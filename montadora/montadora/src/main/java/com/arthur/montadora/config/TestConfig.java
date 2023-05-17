package com.arthur.montadora.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.arthur.montadora.domain.Cliente;
import com.arthur.montadora.domain.OrdemDeServico;
import com.arthur.montadora.domain.Tecnico;
import com.arthur.montadora.domain.enums.Prioridades;
import com.arthur.montadora.domain.enums.Status;
import com.arthur.montadora.repositories.ClienteRepository;
import com.arthur.montadora.repositories.OrdemdeServicoRepository;
import com.arthur.montadora.repositories.TecnicoRepository;
import com.arthur.montadora.services.DbServices;

@Configuration
@Profile("test")
public class TestConfig {
	
private DbServices dbservice; 
	
	public void instanciaDB()throws Exception {
		this.dbservice.instanciaDB();
		
	}
	
}

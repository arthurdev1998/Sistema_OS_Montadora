package com.arthur.montadora;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arthur.montadora.domain.Cliente;
import com.arthur.montadora.domain.OrdemDeServico;
import com.arthur.montadora.domain.Tecnico;
import com.arthur.montadora.domain.enums.Prioridades;
import com.arthur.montadora.domain.enums.Status;
import com.arthur.montadora.repositories.ClienteRepository;
import com.arthur.montadora.repositories.OrdemdeServicoRepository;
import com.arthur.montadora.repositories.TecnicoRepository;

@SpringBootApplication
public class MontadoraApplication  {

	

	
	
	public static void main(String[] args) {
		SpringApplication.run(MontadoraApplication.class, args);
	}



	
	
}


package com.arthur.montadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.montadora.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
	

}

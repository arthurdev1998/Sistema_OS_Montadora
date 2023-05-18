package com.arthur.montadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arthur.montadora.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
@Query("SELECT u FROM Tecnico u WHERE u.cpf =:cpf")
	
	Tecnico findCpf(@Param("cpf") String cpf);
	

}

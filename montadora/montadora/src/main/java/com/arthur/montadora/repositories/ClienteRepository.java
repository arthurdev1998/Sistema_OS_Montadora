package com.arthur.montadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arthur.montadora.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query("SELECT u FROM Cliente u WHERE u.cpf =:cpf")


	Cliente findByCpf(@Param("cpf")String cpf);

}

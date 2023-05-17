package com.arthur.montadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.montadora.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

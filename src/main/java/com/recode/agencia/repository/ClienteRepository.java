package com.recode.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recode.agencia.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByEmail(String email);
}

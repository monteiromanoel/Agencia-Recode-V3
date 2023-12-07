package com.recode.agencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recode.agencia.entity.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
	List<Viagem> findByTipo(String tipo);
	
	List<Viagem>findByDestinoContaining(String destino);

}

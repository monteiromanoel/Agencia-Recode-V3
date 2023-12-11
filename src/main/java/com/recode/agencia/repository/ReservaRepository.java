package com.recode.agencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recode.agencia.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
	List<Reserva> findByIdCliente_Id(Long clienteId);

	
}

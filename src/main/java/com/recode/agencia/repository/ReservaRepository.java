package com.recode.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recode.agencia.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}

package com.recode.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recode.agencia.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByEmail(String email);
	
	@Modifying
    @Transactional
    @Query(value = "DELETE FROM users_roles WHERE user_id = :userId", nativeQuery = true)
    void deleteUserRolesByUserId(Long userId);
	
	@Modifying
    @Transactional
    @Query(value = "DELETE FROM reserva WHERE id_cliente = :userId", nativeQuery = true)
    void deleteReservasByUserId(Long userId);
}

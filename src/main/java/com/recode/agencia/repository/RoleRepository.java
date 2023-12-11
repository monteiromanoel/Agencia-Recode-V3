package com.recode.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recode.agencia.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);
}

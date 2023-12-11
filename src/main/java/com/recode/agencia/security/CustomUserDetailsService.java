package com.recode.agencia.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.recode.agencia.entity.Cliente;
import com.recode.agencia.entity.Role;
import com.recode.agencia.repository.ClienteRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if (cliente != null) {
			return new org.springframework.security.core.userdetails.User(
					cliente.getEmail(),
	                cliente.getSenha(),
	                mapRolesToAuthorities(cliente.getRoles())
	                //,cliente.getId()
					);
					
		} else {
			throw new UsernameNotFoundException("Email ou senha inválidos");
		}
		
	}
	
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	    Cliente cliente = clienteRepository.findByEmail(email);
//
//	    if (cliente != null) {
//	        return new CustomUserDetails(
//	            cliente.getEmail(),
//	            cliente.getSenha(),
//	            mapRolesToAuthorities(cliente.getRoles()),
//	            cliente.getId()
//	        );
//	    } else {
//	        throw new UsernameNotFoundException("Email ou senha inválidos");
//	    }
//	}

	 
	
	private Collection <? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
		Collection <? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		return mapRoles;
	}
}

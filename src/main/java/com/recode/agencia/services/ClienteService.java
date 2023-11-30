package com.recode.agencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.agencia.model.Cliente;
import com.recode.agencia.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> buscarTodosClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente obterClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
}

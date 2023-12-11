package com.recode.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recode.agencia.entity.Cliente;
import com.recode.agencia.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public ClienteService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder) {
		this.clienteRepository = clienteRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public List<Cliente> buscarTodosClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente obterClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
	
	public Cliente createCliente(Cliente cliente) {
		cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
		return clienteRepository.save(cliente);
	}
	
	public Cliente findByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}
	
	@Transactional
    public void excluirCliente(Long clientId) {
        clienteRepository.deleteUserRolesByUserId(clientId);
        clienteRepository.deleteReservasByUserId(clientId);
        clienteRepository.deleteById(clientId);
    }
	
}

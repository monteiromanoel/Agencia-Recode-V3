package com.recode.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recode.agencia.entity.Cliente;
import com.recode.agencia.repository.ClienteRepository;
import com.recode.agencia.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@SuppressWarnings("unused")
	private final ClienteService clienteService;
	
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@SuppressWarnings("unused")
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@GetMapping("/perfil/{emailUser}")
	public String perfil(@PathVariable("emailUser") String email, Model model) {
		Cliente cliente = clienteService.findByEmail(email);
		model.addAttribute("cliente",cliente);
		return "clientes/perfil";
	}
	
}

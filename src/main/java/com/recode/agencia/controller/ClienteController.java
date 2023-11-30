package com.recode.agencia.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.agencia.model.Cliente;
import com.recode.agencia.repository.ClienteRepository;
import com.recode.agencia.services.ClienteService;

@Controller
public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@PostMapping("/cadastrarUsuario")
	public ModelAndView cadastrarCliente(Cliente cliente) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		
		clienteRepository.save(cliente);
		return modelAndView;
	}
}

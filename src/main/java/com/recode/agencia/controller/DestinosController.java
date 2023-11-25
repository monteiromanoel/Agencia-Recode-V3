package com.recode.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.agencia.repository.ViagemRepository;

@Controller
@RequestMapping("destinos")
public class DestinosController {

	@Autowired
	private ViagemRepository viagemRepository;
	
	@GetMapping
	public ModelAndView destino() {
		ModelAndView modelAndView = new ModelAndView("viagens/destino.html");
		modelAndView.addObject("destinos", viagemRepository.findAll());
		return modelAndView;
	}
}

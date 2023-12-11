package com.recode.agencia.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.agencia.dto.UserDto;
import com.recode.agencia.entity.Cliente;
import com.recode.agencia.service.ClienteService;
import com.recode.agencia.service.ViagemService;
import com.recode.agencia.service.imp.UserService;

import jakarta.validation.Valid;

@SuppressWarnings("unused")
@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("unused")
	@Autowired
	private ViagemService viagemService;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto cliente = new UserDto();
		model.addAttribute("cliente", cliente);
		return "cadastro";
	}

	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("cliente") UserDto userDto, BindingResult result, Model model) {
		Cliente clienteExist = userService.findUserByEmail(userDto.getEmail());

		if (clienteExist != null && clienteExist.getEmail() != null && !clienteExist.getEmail().isEmpty()) {
			result.rejectValue("email", null, "Já existe uma conta cadastrada com esse E-mail");
		}

		if (result.hasErrors()) {
			model.addAttribute("cliente", userDto);
			return "cadastro";
		}

		userService.saveUser(userDto);
		return "redirect:/register?success";
	}

	@GetMapping("/users")
	public String users(Model model) {
		List<Cliente> clientes = clienteService.buscarTodosClientes();
		model.addAttribute("clientes", clientes);
		return "dashboard/cliente/listaClientes";
	}

	@GetMapping("/registeradm")
	public String showRegistrationFormAdm(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "dashboard/cliente/cadastro";
	}

	@PostMapping("/registeradm/save")
	public String registrationAdm(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result,
			Model model) {
		Cliente clienteExist = userService.findUserByEmail(cliente.getEmail());

		if (clienteExist != null && clienteExist.getEmail() != null && !clienteExist.getEmail().isEmpty()) {
			result.rejectValue("email", null, "Já existe uma conta cadastrada com esse E-mail");
		}

		if (result.hasErrors()) {
			model.addAttribute("cliente", cliente);
			return "dashboard/cliente/cadastro";
		}

		userService.saveUserAdmin(cliente);
		return "redirect:/registeradm?success";
	}
	
}

package com.recode.agencia.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.recode.agencia.entity.Cliente;
import com.recode.agencia.entity.Reserva;
import com.recode.agencia.entity.Viagem;
import com.recode.agencia.repository.ClienteRepository;
import com.recode.agencia.repository.ReservaRepository;
import com.recode.agencia.service.ClienteService;
import com.recode.agencia.service.ReservaService;
import com.recode.agencia.service.ViagemService;

@Controller
public class ClienteController {
	
	@SuppressWarnings("unused")
	private final ClienteService clienteService;
	
	private final ViagemService viagemService;
	
	private final ReservaService reservaService;
	
	public ClienteController(ClienteService clienteService, ViagemService viagemService, ReservaService reservaService) {
		this.clienteService = clienteService;
		this.viagemService = viagemService;
		this.reservaService = reservaService;
	}
	
	@SuppressWarnings("unused")
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	@GetMapping("/perfil")
	public ModelAndView perfil(Model model, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("clientes/perfil.html"); 
		String email = principal.getName();
		Cliente cliente = clienteService.findByEmail(email);
		model.addAttribute("cliente",cliente);
		return modelAndView;
	}
	
	@PostMapping("/perfil/save")
	public ModelAndView atualizarCliente(@RequestParam("id") Long clienteId, Cliente cliente) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/perfil?editSuccess");
		
		Optional<Cliente> clienteExistenteOpt = clienteRepository.findById(clienteId);
		Cliente clienteExistente = clienteExistenteOpt.get();
		
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setLogradouro(cliente.getLogradouro());
		clienteExistente.setCep(cliente.getCep());
		clienteExistente.setCidade(cliente.getCidade());
		clienteExistente.setUf(cliente.getUf());
		clienteExistente.setTelefone(cliente.getTelefone());
		clienteExistente.setDocumento(cliente.getDocumento());
		clienteExistente.setData_nasc(cliente.getData_nasc());
		
		clienteRepository.save(clienteExistente);
		return modelAndView;
	}
	
	@GetMapping("/confirmaReserva")
	public ModelAndView confimaReserva(@RequestParam("id") Long id, Model model, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("viagens/confirmaReserva.html");
		Viagem viagem = viagemService.obterViagemPorId(id);
		String email = principal.getName();
		Cliente cliente = clienteService.findByEmail(email);
		model.addAttribute("cliente",cliente);
		model.addAttribute("viagem",viagem);
		return modelAndView;
	}
	
	@PostMapping("/confirmaReserva/save")
	public ModelAndView fazerReserva(@RequestParam("idCliente") Long idC, @RequestParam("idViagem") Long idV, @RequestParam("num_passageiros") int num_passageiros, Model model ) {
		ModelAndView modelAndView = new ModelAndView("redirect:/reservasCliente?success");
		
		Cliente cliente = clienteService.obterClientePorId(idC);
		Viagem viagem = viagemService.obterViagemPorId(idV);
		
		Reserva reserva = new Reserva();
		reserva.setIdCliente(cliente);
		reserva.setIdViagem(viagem);
		LocalDate dataReservaLocal = LocalDate.now();
	    reserva.setData_reserva(dataReservaLocal);
		reserva.setNum_passageiros(num_passageiros);
		reserva.setPreco(viagem.getPreco() * num_passageiros);
		
		reservaService.salvar(reserva);
		
		return modelAndView;
	}
	
	@GetMapping("/reservasCliente")
	public ModelAndView reservas(Model model, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("clientes/reservas.html");
		String email = principal.getName();
		Cliente cliente = clienteService.findByEmail(email);
		Long clienteID = cliente.getId();
		List<Reserva> reserva = reservaRepository.findByIdCliente_Id(clienteID);
		modelAndView.addObject("reservas", reserva);
		
		return modelAndView;
	} 
	
	@GetMapping("/detalheReservaCliente")
	public ModelAndView detalheReserva(@RequestParam("idReserva") Long id, Model model) {
		ModelAndView modelAndView = new ModelAndView("clientes/dadosReserva.html");
		Reserva reserva = reservaService.findById(id);
		Viagem viagem = reserva.getIdViagem();
		
		modelAndView.addObject("reserva", reserva);
		modelAndView.addObject("viagem", viagem);
		
		return modelAndView;
	} 
	
	@GetMapping("/deletarReservaCliente")
	public ModelAndView excluirReserva(@RequestParam("idReserva") Long id) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/reservasCliente?deleteSuccess");
	    reservaRepository.deleteById(id);
	    return modelAndView;
	}
	
	
	
}

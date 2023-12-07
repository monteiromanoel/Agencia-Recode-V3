package com.recode.agencia.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.recode.agencia.repository.ViagemRepository;
import com.recode.agencia.service.ClienteService;
import com.recode.agencia.service.ReservaService;
import com.recode.agencia.service.ViagemService;

@Controller
public class AdminController {

	private final ClienteService clienteService;
	
	private final ViagemService viagemService;
	
	private final ReservaService reservaService;
	
	private final PasswordEncoder passwordEncoder;
	
	public AdminController(ClienteService clienteService, ViagemService viagemService, ReservaService reservaService,PasswordEncoder passwordEncoder) {
		this.clienteService = clienteService;
		this.viagemService = viagemService;
		this.reservaService = reservaService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	@GetMapping("/adm")
	public String index() {
		return "dashboard/index.html";
	}
	
	
	// CLIENTES
	@GetMapping("/clientes")
	public ModelAndView clientes() {
		ModelAndView modelAndView = new ModelAndView("dashboard/cliente/listaClientes.html");
		modelAndView.addObject("clientes", clienteRepository.findAll());
		
		return modelAndView;
	}
	
	
	@GetMapping("/detalheCliente")
	public String detalheCliente(@RequestParam("id") Long id, Model model) {
		Cliente cliente = clienteService.obterClientePorId(id);
		
		model.addAttribute("cliente",cliente);
		return "dashboard/cliente/detalheCliente.html";
	}
	
	@GetMapping("/editarCliente")
	public String editarCliente(@RequestParam("id") Long id, Model model) {
		Cliente cliente = clienteService.obterClientePorId(id);
		
		model.addAttribute("cliente",cliente);
		return "dashboard/cliente/editar.html";
	}
	
	@PostMapping("/editarCliente/save")
	public ModelAndView atualizarCliente(@RequestParam("id") Long clienteId, Cliente cliente) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/users?editSuccess");
		
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
		clienteExistente.setSenha(passwordEncoder.encode(cliente.getSenha()));
		
		clienteRepository.save(clienteExistente);
		return modelAndView;
	}
	
	@GetMapping("/deletarCliente")
	public ModelAndView excluirCliente(@RequestParam Long id) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/users?deleteSuccess");
	    clienteRepository.deleteById(id);
	    return modelAndView;
	}
	
	// VIAGENS
	@GetMapping("/viagens")
	public ModelAndView viagens() {
		ModelAndView modelAndView = new ModelAndView("dashboard/viagem/listaViagens.html");
		modelAndView.addObject("viagens", viagemRepository.findAll());
		
		return modelAndView;
	} 
	
	@GetMapping("/detalheViagem")
	public String detalheViagem(@RequestParam("id") Long id, Model model) {
		Viagem viagem = viagemService.obterViagemPorId(id);
		
		model.addAttribute("viagem",viagem);
		return "dashboard/viagem/detalheViagem.html";
	}
	
	@GetMapping("/cadastroDestino")
	public String cadastroDestino() {
		return "dashboard/viagem/cadastro.html";
	}
	
	@PostMapping("/cadastrarDestino")
	public ModelAndView cadastrarDestino(Viagem viagem) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/viagens?success");
		
		viagemRepository.save(viagem);
		return modelAndView;
	}
	
	@GetMapping("/editarViagem")
	public String editarViagem(@RequestParam("id") Long id, Model model) {
		Viagem viagem = viagemService.obterViagemPorId(id);
		
		model.addAttribute("viagem",viagem);
		return "dashboard/viagem/editar.html";
	}
	
	@PostMapping("/editarViagem")
	public ModelAndView atualizarViagem(@RequestParam("id") Long viagemId, Viagem viagem) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/viagens?editSuccess");
		
		Optional<Viagem> viagemExistenteOpt = viagemRepository.findById(viagemId);
		Viagem viagemExistente = viagemExistenteOpt.get();
		
		viagemExistente.setDestino(viagem.getDestino());
		viagemExistente.setLocalidade(viagem.getLocalidade());
		viagemExistente.setData_ida(viagem.getData_ida());
		viagemExistente.setData_volta(viagem.getData_volta());
		viagemExistente.setAdicional(viagem.getAdicional());
		viagemExistente.setTipo(viagem.getTipo());
		viagemExistente.setDescricao_curta(viagem.getDescricao_curta());
		viagemExistente.setDescricao_longa(viagem.getDescricao_longa());
		viagemExistente.setLabel_promocao(viagem.getLabel_promocao());
		Double precoAntigoDb = viagem.getPreco_antigo();
        viagemExistente.setPreco_antigo(precoAntigoDb);
		Double precoDb = viagem.getPreco();
		viagemExistente.setPreco(precoDb);
		viagemExistente.setImagem(viagem.getImagem());
		viagemExistente.setImagem2(viagem.getImagem2());
		viagemExistente.setImagem3(viagem.getImagem3());
		viagemExistente.setImagem4(viagem.getImagem4());
		
		viagemRepository.save(viagemExistente);
		return modelAndView;
	}
	
	@GetMapping("/deletarViagem")
	public ModelAndView excluirViagem(@RequestParam Long id) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/viagens?deleteSuccess");
	    viagemRepository.deleteById(id);
	    return modelAndView;
	}
	
	// RESERVAS
	@GetMapping("/reservas")
	public ModelAndView reservas() {
		ModelAndView modelAndView = new ModelAndView("dashboard/reserva/listaReservas.html");
		modelAndView.addObject("reservas", reservaRepository.findAll());
		
		return modelAndView;
	} 
	
	@GetMapping("/detalheReserva")
	public ModelAndView detalheReserva(@RequestParam("idReserva") Long idR, @RequestParam("idCliente") Long idC, @RequestParam("idViagem") Long idV, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("dashboard/reserva/detalheReserva.html");
		
		//Optional<Cliente> cliente = clienteRepository.findById(idC);
		Cliente cliente = clienteService.obterClientePorId(idC);
		modelAndView.addObject("cliente", cliente);
		
		//Optional<Viagem> viagem = viagemRepository.findById(idV);
		Viagem viagem = viagemService.obterViagemPorId(idV);
		modelAndView.addObject("viagem", viagem);
		
		//Optional<Reserva> reserva = reservaRepository.findById(idR);
		Reserva reserva = reservaService.findById(idR);
		modelAndView.addObject("reserva", reserva);
		
		return modelAndView;
	}
	
	@GetMapping("/cadastroReserva")
	public ModelAndView cadastroReserva() {
		
		ModelAndView modelAndView = new ModelAndView("dashboard/reserva/cadastro.html");
		modelAndView.addObject("clientes", clienteRepository.findAll());
		modelAndView.addObject("viagens", viagemRepository.findAll());
		
		return modelAndView;
	}
	
	@PostMapping("/cadastroReserva/save")
	public ModelAndView fazerReserva(@RequestParam("idCliente") Long idC, @RequestParam("idViagem") Long idV, @RequestParam("num_passageiros") int num_passageiros, Model model ) {
		ModelAndView modelAndView = new ModelAndView("redirect:/reservas?success");
		
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
	
	@GetMapping("/deletarReserva")
	public ModelAndView excluirReserva(@RequestParam Long id) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/reservas?deleteSuccess");
	    reservaRepository.deleteById(id);
	    return modelAndView;
	}
	
	
	
}

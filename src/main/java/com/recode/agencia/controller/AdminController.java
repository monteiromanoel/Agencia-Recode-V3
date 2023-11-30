package com.recode.agencia.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.recode.agencia.model.Cliente;
import com.recode.agencia.model.Viagem;
import com.recode.agencia.repository.ClienteRepository;
import com.recode.agencia.repository.ViagemRepository;
import com.recode.agencia.services.ClienteService;
import com.recode.agencia.services.ViagemService;

@Controller
public class AdminController {

	private final ClienteService clienteService;
	
	private final ViagemService viagemService;
	
	public AdminController(ClienteService clienteService, ViagemService viagemService) {
		this.clienteService = clienteService;
		this.viagemService = viagemService;
	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	
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
	
	@PostMapping("/editarCliente")
	public ModelAndView atualizarCliente(@RequestParam("id") Long clienteId, Cliente cliente) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");
		
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
		clienteExistente.setSenha(cliente.getSenha());
		clienteExistente.setRole(cliente.getRole());
		
		clienteRepository.save(clienteExistente);
		return modelAndView;
	}
	
	@GetMapping("/deletarCliente")
	public ModelAndView excluirCliente(@RequestParam Long id) {
	    ModelAndView modelAndView = new ModelAndView("redirect:/clientes");
	    clienteRepository.deleteById(id);
	    return modelAndView;
	}
	
	@GetMapping("/cadastroCliente")
	public String cadastroCliente() {
		return "dashboard/cliente/cadastro.html";
	}
	
	@PostMapping("/cadastrarCliente")
	public ModelAndView cadastrarCliente(Cliente cliente) throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");
		
		clienteRepository.save(cliente);
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
		ModelAndView modelAndView = new ModelAndView("redirect:/viagens");
		
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
		ModelAndView modelAndView = new ModelAndView("redirect:/viagens");
		
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
	    ModelAndView modelAndView = new ModelAndView("redirect:/viagens");
	    viagemRepository.deleteById(id);
	    return modelAndView;
	}
	
}

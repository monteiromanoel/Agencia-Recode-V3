package com.recode.agencia.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recode.agencia.model.Viagem;
import com.recode.agencia.services.ViagemService;

@Controller
public class DestinosController {

	
	private final ViagemService viagemService;
	
	public DestinosController(ViagemService viagemService) {
        this.viagemService = viagemService;
    };
	
	@GetMapping("/destinos")
	public String destinosConvencionais(Model model) {
		List<Viagem> todasViagens = viagemService.buscarTodasViagens();
	    
	    // Filtrar viagens convencionais nacionais (localidade = Brasil)
	    List<Viagem> viagensNacionaisConvencionais = todasViagens.stream()
	            .filter(viagem -> "convencional".equals(viagem.getTipo()) && "Brasil".equals(viagem.getLocalidade()))
	            .collect(Collectors.toList());

	    // Filtrar viagens convencionais internacionais (localidade != Brasil)
	    List<Viagem> viagensInternacionaisConvencionais = todasViagens.stream()
	            .filter(viagem -> "convencional".equals(viagem.getTipo()) && !"Brasil".equals(viagem.getLocalidade()))
	            .collect(Collectors.toList());

	    model.addAttribute("viagensInterConv", viagensInternacionaisConvencionais);
	    model.addAttribute("viagensNacConv", viagensNacionaisConvencionais);
		return "viagens/destino.html";
		
	};
	
	@GetMapping("/promocoes")
	public String destinosPromocionais(Model model) {
		List<Viagem> todasViagens = viagemService.buscarTodasViagens();
	    
	    // Filtrar viagens convencionais nacionais (localidade = Brasil)
	    List<Viagem> viagensNacionaisPromocionais = todasViagens.stream()
	            .filter(viagem -> "promocional".equals(viagem.getTipo()) && "Brasil".equals(viagem.getLocalidade()))
	            .collect(Collectors.toList());

	    // Filtrar viagens convencionais internacionais (localidade != Brasil)
	    List<Viagem> viagensInternacionaisPromocionais = todasViagens.stream()
	            .filter(viagem -> "promocional".equals(viagem.getTipo()) && !"Brasil".equals(viagem.getLocalidade()))
	            .collect(Collectors.toList());

	    model.addAttribute("viagensInterProm", viagensInternacionaisPromocionais);
	    model.addAttribute("viagensNacProm", viagensNacionaisPromocionais);
		return "viagens/promocoes.html";
		
	};
	
	@GetMapping("/detalheDestino")
	public String detalheDestino(@RequestParam("id") Long id, Model model) {
		Viagem viagem = viagemService.obterViagemPorId(id);
		
		model.addAttribute("viagem",viagem);
		return "viagens/detalheDestino.html";
	};
	
	@GetMapping("/detalhePromocao")
	public String detalhePromocao(@RequestParam("id") Long id, Model model) {
		Viagem viagem = viagemService.obterViagemPorId(id);
		
		model.addAttribute("viagem",viagem);
		return "viagens/detalhePromocao.html";
	};
	
	@PostMapping("/pesquisa")
	public String pesquisarViagens(@RequestParam("pesquisaDestino") String pesquisaDestino, Model model) {
		List<Viagem> resultadosPesquisa = viagemService.buscarPorDestino(pesquisaDestino);
		model.addAttribute("resultados",resultadosPesquisa);
		return "resultadoPesquisa.html";
	}
	
}

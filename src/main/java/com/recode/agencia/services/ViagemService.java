package com.recode.agencia.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.agencia.model.Viagem;
import com.recode.agencia.repository.ViagemRepository;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	public List<Viagem> buscarTodasViagens(){
		return viagemRepository.findAll();
	}
	
	public List<Viagem> obterViagensPorTipo(String tipo){
		List<Viagem> todasViagens = buscarTodasViagens();
		
		List<Viagem> viagensPorTipo = todasViagens.stream()
				.filter(viagem -> tipo.equals(viagem.getTipo()))
				.collect(Collectors.toList());
		
		return viagensPorTipo;
	}
	
	public Viagem obterViagemPorId(Long id) {
		Optional<Viagem> viagem = viagemRepository.findById(id);
		return viagem.get();
	}
	
	public List<Viagem> buscarPorDestino(String destino) {
		return viagemRepository.findByDestinoContaining(destino);
	}
}

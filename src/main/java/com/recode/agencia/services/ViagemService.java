package com.recode.agencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.agencia.model.Viagem;
import com.recode.agencia.repository.ViagemRepository;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	public List<Viagem> buscarPacotesPorTipoPacote(String tipo_pacote){
		return viagemRepository.findByTipo_pacote(tipo_pacote);
	}
}

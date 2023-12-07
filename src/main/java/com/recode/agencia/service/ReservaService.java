package com.recode.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.agencia.entity.Reserva;
import com.recode.agencia.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	public List<Reserva> buscarTodasReservas(){
		return reservaRepository.findAll();
	}
	
	public Reserva findById(Long Id) {
		Optional<Reserva> reserva = reservaRepository.findById(Id);
		return reserva.get();
	}
	
	public Reserva salvar(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
}

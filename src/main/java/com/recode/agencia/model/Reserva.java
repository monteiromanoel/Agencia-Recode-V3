package com.recode.agencia.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int num_passageiros;
	
	@Column
	private Date data_reserva;
	
	@Column
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente idCliente;
	
	@ManyToOne
	@JoinColumn(name = "idViagem")
	private Viagem idViagem;
	
	public Reserva() {
		
	}

	public Reserva(Long id, int num_passageiros, Date data_reserva, Double preco, Cliente idCliente, Viagem idViagem) {
		super();
		this.id = id;
		this.num_passageiros = num_passageiros;
		this.data_reserva = data_reserva;
		this.preco = preco;
		this.idCliente = idCliente;
		this.idViagem = idViagem;
	}
	
	
}

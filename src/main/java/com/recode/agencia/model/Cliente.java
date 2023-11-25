package com.recode.agencia.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@Column
	private String documento;
	
	@Column
	private String telefone;
	
	@Column
	private String logradouro;
	
	@Column
	private String cep;
	
	@Column
	private String cidade;
	
	@Column
	private String uf;
	
	@Column
	private LocalDate data_nasc;
	
	public Cliente() {
		
	}

	public Cliente(Long id, String nome, String email, String senha, String documento, String telefone,
			String logradouro, String cep, String cidade, String uf, LocalDate data_nasc) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.documento = documento;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.data_nasc = data_nasc;
	}
	
	
	
	
}

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
@Table(name = "viagem")
public class Viagem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String destino;
	
	@Column
	private Double preco;
	
	@Column
	private LocalDate data_ida;
	
	@Column
	private LocalDate data_volta;
	
	@Column
	private String descricao_curta;
	
	@Column
	private String adicional;
	
	@Column
	private String localidade;
	
	@Column
	private String imagem;
	
	@Column
	private String tipo_pacote;
	
	@Column
	private String descricao_longa;
	
	@Column
	private String label_promocao;
	
	@Column
	private String imagem2;
	
	@Column
	private String imagem3;
	
	@Column
	private String imagem4;
	
	@Column
	private Double preco_antigo;
	
	public Viagem() {
		
	}

	public Viagem(Long id, String destino, Double preco, LocalDate data_ida, LocalDate data_volta,
			String descricao_curta, String adicional, String localidade, String imagem, String tipo_pacote,
			String descricao_longa, String label_promocao, String imagem2, String imagem3, String imagem4,
			Double preco_antigo) {
		super();
		this.id = id;
		this.destino = destino;
		this.preco = preco;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.descricao_curta = descricao_curta;
		this.adicional = adicional;
		this.localidade = localidade;
		this.imagem = imagem;
		this.tipo_pacote = tipo_pacote;
		this.descricao_longa = descricao_longa;
		this.label_promocao = label_promocao;
		this.imagem2 = imagem2;
		this.imagem3 = imagem3;
		this.imagem4 = imagem4;
		this.preco_antigo = preco_antigo;
	}
	
	
}

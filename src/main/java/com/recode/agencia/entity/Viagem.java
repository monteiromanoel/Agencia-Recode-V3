package com.recode.agencia.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
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
	private String tipo;
	
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
			String descricao_curta, String adicional, String localidade, String imagem, String tipo,
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
		this.tipo = tipo;
		this.descricao_longa = descricao_longa;
		this.label_promocao = label_promocao;
		this.imagem2 = imagem2;
		this.imagem3 = imagem3;
		this.imagem4 = imagem4;
		this.preco_antigo = preco_antigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public LocalDate getData_ida() {
		return data_ida;
	}

	public void setData_ida(LocalDate data_ida) {
		this.data_ida = data_ida;
	}

	public LocalDate getData_volta() {
		return data_volta;
	}

	public void setData_volta(LocalDate data_volta) {
		this.data_volta = data_volta;
	}

	public String getDescricao_curta() {
		return descricao_curta;
	}

	public void setDescricao_curta(String descricao_curta) {
		this.descricao_curta = descricao_curta;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao_longa() {
		return descricao_longa;
	}

	public void setDescricao_longa(String descricao_longa) {
		this.descricao_longa = descricao_longa;
	}

	public String getLabel_promocao() {
		return label_promocao;
	}

	public void setLabel_promocao(String label_promocao) {
		this.label_promocao = label_promocao;
	}

	public String getImagem2() {
		return imagem2;
	}

	public void setImagem2(String imagem2) {
		this.imagem2 = imagem2;
	}

	public String getImagem3() {
		return imagem3;
	}

	public void setImagem3(String imagem3) {
		this.imagem3 = imagem3;
	}

	public String getImagem4() {
		return imagem4;
	}

	public void setImagem4(String imagem4) {
		this.imagem4 = imagem4;
	}

	public Double getPreco_antigo() {
		return preco_antigo;
	}

	public void setPreco_antigo(Double preco_antigo) {
		this.preco_antigo = preco_antigo;
	}

	
	

	
	
	
}

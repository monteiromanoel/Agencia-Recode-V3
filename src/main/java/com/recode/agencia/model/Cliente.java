package com.recode.agencia.model;

import java.time.LocalDate;
import java.util.Objects;

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
	
	@Column
	private String role;
	
	public Cliente() {
		
	}

	public Cliente(Long id, String nome, String email, String senha, String documento, String telefone,
			String logradouro, String cep, String cidade, String uf, LocalDate data_nasc, String role) {
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
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", documento="
				+ documento + ", telefone=" + telefone + ", logradouro=" + logradouro + ", cep=" + cep + ", cidade="
				+ cidade + ", uf=" + uf + ", data_nasc=" + data_nasc + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, data_nasc, documento, email, id, logradouro, nome, role, senha, telefone, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(data_nasc, other.data_nasc) && Objects.equals(documento, other.documento)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& Objects.equals(role, other.role) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(uf, other.uf);
	}

	
	
	
	
	
}

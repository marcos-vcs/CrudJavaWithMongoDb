package com.transportadora.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "entregador")
public class Entregador {
	@Id
	private String id;
	
	private String nome        = "";
	private String cpf         = "";
	private String nascData    = "";
	private String habilitacao = "";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNascData() {
		return nascData;
	}
	public void setNascData(String nascData) {
		this.nascData = nascData;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	@Override
	public String toString() {
		return "Entregador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", nascData=" + nascData + ", habilitacao="
				+ habilitacao + "]";
	}
	
	
	
}

package com.transportadora.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "origem")
public class Origem {
		
	@Id
	private String id          = null;
	
	private String cep         = "";
	private String rua         = "";
	private String complemento = "";
	private String cidade      = "";
	private String estado      = "";
	
	
	public Origem() {
		UUID uuid = UUID.randomUUID();
		
		if(this.id == null || this.id == "") {
			this.id = uuid.toString();
		}
	}
	
	
	

	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getCep() {
		return cep;
	}




	public void setCep(String cep) {
		this.cep = cep;
	}




	public String getRua() {
		return rua;
	}




	public void setRua(String rua) {
		this.rua = rua;
	}




	public String getComplemento() {
		return complemento;
	}




	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Origem [id=" + id + ", cep=" + cep + ", rua=" + rua + ", complemento=" + complemento + ", cidade="
				+ cidade + ", estado=" + estado + "]";
	}
	
	

}

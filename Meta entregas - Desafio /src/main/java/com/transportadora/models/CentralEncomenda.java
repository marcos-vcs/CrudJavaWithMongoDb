package com.transportadora.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CentralEncomenda {
	
	private String cepOrigem           = "";
	private String cepDestino          = "";
	private String ruaOrigem           = "";
	private String ruaDestino          = "";
	private String complementoOrigem   = "";
	private String complementoDestino  = "";
	private String cidadeOrigem        = "";
	private String cidadeDestino       = "";
	private String estadoOrigem        = "";
	private String estadoDestino       = "";

	public String getCepOrigem() {
		return cepOrigem;
	}
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	public String getCepDestino() {
		return cepDestino;
	}
	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}
	public String getRuaOrigem() {
		return ruaOrigem;
	}
	public void setRuaOrigem(String ruaOrigem) {
		this.ruaOrigem = ruaOrigem;
	}
	public String getRuaDestino() {
		return ruaDestino;
	}
	public void setRuaDestino(String ruaDestino) {
		this.ruaDestino = ruaDestino;
	}
	public String getComplementoOrigem() {
		return complementoOrigem;
	}
	public void setComplementoOrigem(String complementoOrigem) {
		this.complementoOrigem = complementoOrigem;
	}
	public String getComplementoDestino() {
		return complementoDestino;
	}
	public void setComplementoDestino(String complementoDestino) {
		this.complementoDestino = complementoDestino;
	}
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}
	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
	public String getCidadeDestino() {
		return cidadeDestino;
	}
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}
	public String getEstadoOrigem() {
		return estadoOrigem;
	}
	public void setEstadoOrigem(String estadoOrigem) {
		this.estadoOrigem = estadoOrigem;
	}
	public String getEstadoDestino() {
		return estadoDestino;
	}
	public void setEstadoDestino(String estadoDestino) {
		this.estadoDestino = estadoDestino;
	}
	@Override
	public String toString() {
		return "CentralEncomenda [cepOrigem=" + cepOrigem + ", cepDestino=" + cepDestino + ", ruaOrigem=" + ruaOrigem
				+ ", ruaDestino=" + ruaDestino + ", complementoOrigem=" + complementoOrigem + ", complementoDestino="
				+ complementoDestino + ", cidadeOrigem=" + cidadeOrigem + ", cidadeDestino=" + cidadeDestino
				+ ", estadoOrigem=" + estadoOrigem + ", estadoDestino=" + estadoDestino + "]";
	}
	
	
	
	

}

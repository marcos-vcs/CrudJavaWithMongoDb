package meta.stock.java;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Carros")
public class ModeloClass {
	
	@Id
	private String id;
	
	private String  marca;
	private String  modelo;
	private String  versao;
	private String  cor;
	private String  combustivel;
	private String  cambio;
	private String  opcionais;
	private int     anoConstruido;
	private int     anoDesenvolvido;
	private int     qtdKm;
	private String  placa;
	private String  carroceria;
	private int     numPortas;
	private int     qtdDonos;
	private float   valor;
	private String  observacao;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public String getOpcionais() {
		return opcionais;
	}
	public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}
	public int getAnoConstruido() {
		return anoConstruido;
	}
	public void setAnoConstruido(int anoConstruido) {
		this.anoConstruido = anoConstruido;
	}
	public int getAnoDesenvolvido() {
		return anoDesenvolvido;
	}
	public void setAnoDesenvolvido(int anoDesenvolvido) {
		this.anoDesenvolvido = anoDesenvolvido;
	}
	public int getQtdKm() {
		return qtdKm;
	}
	public void setQtdKm(int qtdKm) {
		this.qtdKm = qtdKm;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCarroceria() {
		return carroceria;
	}
	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}
	public int getNumPortas() {
		return numPortas;
	}
	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
	public int getQtdDonos() {
		return qtdDonos;
	}
	public void setQtdDonos(int qtdDonos) {
		this.qtdDonos = qtdDonos;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
	
	

}

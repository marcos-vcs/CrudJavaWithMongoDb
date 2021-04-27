package com.transportadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportadora.models.CentralEncomenda;
import com.transportadora.models.Destino;
import com.transportadora.models.Origem;
import com.transportadora.repositories.RepDestino;
import com.transportadora.repositories.RepOrigem;

@Service
public class EntregasService {

	@Autowired
	private  RepDestino destino;
	@Autowired
	private  RepOrigem  origem;
	
	//Create
	public void save(CentralEncomenda encomenda) {
		Destino destino = new Destino();
		Origem  origem  = new  Origem();
		
		origem.setCep(encomenda.getCepOrigem());
		origem.setRua(encomenda.getRuaOrigem());
		origem.setComplemento(encomenda.getComplementoOrigem());
		origem.setCidade(encomenda.getCidadeOrigem());
		origem.setEstado(encomenda.getEstadoOrigem());
		
		destino.setId(origem.getId());
		destino.setCep(encomenda.getCepDestino());
		destino.setRua(encomenda.getRuaDestino());
		destino.setComplemento(encomenda.getEstadoDestino());
		destino.setCidade(encomenda.getCidadeDestino());
		destino.setEstado(encomenda.getEstadoDestino());
		
		this.origem.save(origem);
		
		this.destino.save(destino);

	}
	
	//Create Origem
	public void saveOrigem(Origem origem) {
		this.origem.save(origem);
	}
	
	//Create Destino
	public void saveDestino(Destino destino) {
		this.destino.save(destino);
	}
	
	//Read origem
	public List<Origem> listOrigem(){
		return (List<Origem>) origem.findAll();
	}
	//read destino
	public List<Destino> listDestino(){
		return (List<Destino>) destino.findAll();
	}
	
	//read from id destino
	public Optional<Destino> getDestino(String id){
		return destino.findById(id);
	}
	
	//read from id origem
	public Optional<Origem> getOrigem(String id){
		return origem.findById(id);
	}
	
	//deleta
	public void delete(String id) {
		destino.deleteById(id);
		origem.deleteById(id);
	}
	
	
}

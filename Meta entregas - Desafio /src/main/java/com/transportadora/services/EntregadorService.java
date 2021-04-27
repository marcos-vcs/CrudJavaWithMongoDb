package com.transportadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportadora.models.Entregador;
import com.transportadora.repositories.RepEntregador;

@Service
public class EntregadorService {
	
	@Autowired
	private RepEntregador repository;
	
	//read
	public List<Entregador> listAll(){
		return (List<Entregador>) repository.findAll();
	}
	
	//read from id
	public Optional<Entregador> getEntregador(String id){
		return repository.findById(id.toString());
	}
	
	//create
	public void save(Entregador entregador) {
		repository.save(entregador);
	}
	
	//delete
	public void delete(String id) {
		repository.deleteById(id.toString());
	}
	

}

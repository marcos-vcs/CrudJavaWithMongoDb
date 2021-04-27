package com.transportadora.repositories;

import org.springframework.data.repository.CrudRepository;

import com.transportadora.models.Entregador;

public interface RepEntregador extends CrudRepository<Entregador, String> {

	@Override
	public void delete(Entregador entregador);
	
}

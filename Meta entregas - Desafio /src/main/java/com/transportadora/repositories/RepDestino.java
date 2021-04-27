package com.transportadora.repositories;

import org.springframework.data.repository.CrudRepository;

import com.transportadora.models.Destino;

public interface RepDestino extends CrudRepository<Destino, String> {

	@Override
	public void delete(Destino destino);
	
}

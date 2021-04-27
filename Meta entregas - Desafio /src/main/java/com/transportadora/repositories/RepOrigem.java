package com.transportadora.repositories;

import org.springframework.data.repository.CrudRepository;

import com.transportadora.models.Origem;

public interface RepOrigem extends CrudRepository<Origem, String> {
	
	@Override
	public void delete(Origem origem);

}

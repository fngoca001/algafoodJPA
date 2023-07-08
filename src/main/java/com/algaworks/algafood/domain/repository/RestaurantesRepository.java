package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.entity.Restaurante;

public interface RestaurantesRepository {

	List<Restaurante> listar();
	Restaurante porId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Restaurante restaurante);
}

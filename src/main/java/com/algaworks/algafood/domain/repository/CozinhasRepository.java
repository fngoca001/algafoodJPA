package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.entity.Cozinha;

public interface CozinhasRepository {

	List<Cozinha> todos();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Cozinha cozinha);
}

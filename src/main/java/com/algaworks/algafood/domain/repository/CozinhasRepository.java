package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.entity.Cozinha;

public interface CozinhasRepository {

	List<Cozinha> listar();
	Cozinha porId(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long cozinhaId);
}

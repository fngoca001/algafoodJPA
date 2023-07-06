package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.entity.Permissao;

public interface PermissoesRepository {

	List<Permissao> todos();
	Permissao porId(Long id);
	Permissao adicionar(Permissao permissao);
	void remover(Permissao permissao);
}

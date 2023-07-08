package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.entity.Estado;

public interface EstadosRepository {

	List<Estado> listar();
	Estado porId(Long id);
	Estado adicionar(Estado estado);
	void remover(Estado estado);
}

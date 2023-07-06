package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.repository.CozinhasRepository;
import com.algaworks.algafood.domain.repository.EstadosRepository;

@Component
public class EstadoRepositoryImpl implements EstadosRepository{

	@PersistenceContext
	private EntityManager maneger;
	
	@Override
	public List<Estado> listar() {

		return maneger.createQuery("from Estado", Estado.class).getResultList();
	}
	
	@Override
	public Estado porId(Long id) {
		return maneger.find(Estado.class, id);
	}

	@Transactional
	@Override
	public Estado adicionar(Estado estado) {
		return maneger.merge(estado);
	}
	
	@Transactional
	@Override
	public void remover(Estado estado) {
		estado = porId(estado.getId());
		maneger.remove(estado);
	}
}

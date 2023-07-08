package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhasRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhasRepository{

	@PersistenceContext
	private EntityManager maneger;
	
	@Override
	public List<Cozinha> listar() {

		return maneger.createQuery("from Cozinha", Cozinha.class).getResultList();
	}
	
	@Override
	public Cozinha porId(Long id) {
		return maneger.find(Cozinha.class, id);
	}

	@Transactional
	@Override
	public Cozinha adicionar(Cozinha cozinha) {
		return maneger.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		cozinha = porId(cozinha.getId());
		maneger.remove(cozinha);
	}
}

package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.repository.RestaurantesRepository;

@Component
public class RestauranteRepositoryImpl implements RestaurantesRepository{

	@PersistenceContext
	private EntityManager maneger;
	
	@Override
	public List<Restaurante> todos() {

		return maneger.createQuery("from Cozinha", Restaurante.class).getResultList();
	}
	
	@Override
	public Restaurante porId(Long id) {
		return maneger.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public Restaurante adicionar(Restaurante restaurante) {
		return maneger.merge(restaurante);
	}
	
	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		restaurante = porId(restaurante.getId());
		maneger.remove(restaurante);
	}
}

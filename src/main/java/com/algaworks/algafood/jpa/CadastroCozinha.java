package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.entity.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager maneger;

	public List<Cozinha> listar() {

		return maneger.createQuery("from Cozinha", Cozinha.class).getResultList();
	}

	public Cozinha adiccoCozinha(Cozinha cozinha) {
		return maneger.merge(cozinha);
	}
}

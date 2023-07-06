package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.repository.CidadesRepository;

@Component
public class CidadeRepositoryImpl implements CidadesRepository{

	@PersistenceContext
	private EntityManager maneger;
	
	@Override
	public List<Cidade> listar() {

		return maneger.createQuery("from Cidade", Cidade.class).getResultList();
	}
	
	@Override
	public Cidade porId(Long id) {
		return maneger.find(Cidade.class, id);
	}

	@Transactional
	@Override
	public Cidade adicionar(Cidade cidade) {
		return maneger.merge(cidade);
	}
	
	@Transactional
	@Override
	public void remover(Cidade cidade) {
		cidade = porId(cidade.getId());
		maneger.remove(cidade);
	}
}

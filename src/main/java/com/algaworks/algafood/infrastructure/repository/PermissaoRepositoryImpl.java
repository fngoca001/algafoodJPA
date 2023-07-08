package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.entity.Permissao;
import com.algaworks.algafood.domain.repository.CozinhasRepository;
import com.algaworks.algafood.domain.repository.PermissoesRepository;

@Component
public class PermissaoRepositoryImpl implements PermissoesRepository{

	@PersistenceContext
	private EntityManager maneger;
	
	@Override
	public List<Permissao> listar() {

		return maneger.createQuery("from Permissao", Permissao.class).getResultList();
	}
	
	@Override
	public Permissao porId(Long id) {
		return maneger.find(Permissao.class, id);
	}

	@Transactional
	@Override
	public Permissao adicionar(Permissao permissao) {
		return maneger.merge(permissao);
	}
	
	@Transactional
	@Override
	public void remover(Permissao permissao) {
		permissao = porId(permissao.getId());
		maneger.remove(permissao);
	}
}

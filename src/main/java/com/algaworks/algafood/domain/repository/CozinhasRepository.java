package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.entity.Cozinha;

public interface CozinhasRepository extends JpaRepository<Cozinha, Long>{

//	List<Cozinha> consultarPorNome(String nome);
	
}

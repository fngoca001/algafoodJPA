package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.entity.Cozinha;

public interface CozinhasRepository extends JpaRepository<Cozinha, Long>{

	List<Cozinha>  findTodosByNome(String nome);
	
	Optional<Cozinha> findByNome(String nome);
	
	boolean existsByNome(String nome);
	
}

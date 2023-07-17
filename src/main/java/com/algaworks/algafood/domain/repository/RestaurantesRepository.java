package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.entity.Restaurante;

public interface RestaurantesRepository extends JpaRepository<Restaurante, Long>{

	//Retorna uma lista de restaurante num intervalo de taxa frete
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha); 
	
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	List<Restaurante>findTop2ByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinha);
}

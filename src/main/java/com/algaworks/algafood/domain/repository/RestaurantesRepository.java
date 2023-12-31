package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algaworks.algafood.domain.entity.Restaurante;

public interface RestaurantesRepository
		extends CustomJpaRepository<Restaurante, Long>, RestaurantesRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

	@Query("from Restaurante r join fetch r.cozinha join fetch r.formaPagamento")
	List<Restaurante> findAll();
	
	// Retorna uma lista de restaurante num intervalo de taxa frete
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

	// @Query("from from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

	List<Restaurante> findTop2ByNomeContaining(String nome);

	int countByCozinhaId(Long cozinha);

	List<Restaurante> find(String nome, BigDecimal taxaFerteInicial, BigDecimal taxaFreteFinal);
}

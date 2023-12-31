package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.entity.Restaurante;

public interface RestaurantesRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFerteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);
}
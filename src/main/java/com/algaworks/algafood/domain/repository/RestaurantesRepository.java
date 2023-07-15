package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.entity.Restaurante;

public interface RestaurantesRepository extends JpaRepository<Restaurante, Long>{

}

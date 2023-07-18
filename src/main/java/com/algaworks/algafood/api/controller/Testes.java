package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhasRepository;
import com.algaworks.algafood.domain.repository.RestaurantesRepository;

@RestController
@RequestMapping("/teste")
public class Testes {

	@Autowired
	private CozinhasRepository cozinhasRepository;
	
	@Autowired 
	private RestaurantesRepository restaurantesRepository;
	
	@GetMapping("/restaurante/por-nome")
	public List<Restaurante> restaurantePorNpme(String nome, Long cozinhaId){
		return restaurantesRepository.consultarPorNome(nome, cozinhaId);
	}
	
	
}

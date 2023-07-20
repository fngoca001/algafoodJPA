package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
	public List<Restaurante> restaurantePorNpme(String nome, Long cozinhaId) {
		return restaurantesRepository.consultarPorNome(nome, cozinhaId);
	}

	@GetMapping("/restaurante/por-nome-frete")
	public List<Restaurante> restaurantesPorNomeFrete(String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxafreteFinal) {
		return restaurantesRepository.find(nome, taxaFreteInicial, taxafreteFinal);
	}
	
	@GetMapping("/restaurante/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome){
		return restaurantesRepository.findComFreteGratis(nome);
	}
	
	@GetMapping("/restaurante/buscar-primeiro")
	public Optional<Restaurante> buscarPrimeiro(){
		return restaurantesRepository.buscarPrimeiro();
	}

}

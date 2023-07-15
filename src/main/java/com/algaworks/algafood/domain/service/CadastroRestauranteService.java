package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhasRepository;
import com.algaworks.algafood.domain.repository.RestaurantesRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestaurantesRepository restaurantesRepository;
	
	@Autowired
	private CozinhasRepository cozinhasRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhasRepository.findById(cozinhaId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Nao existe cadastro de uma Cozinha de codigo %d", cozinhaId)));
		
		restaurante.setCozinha(cozinha);

		return restaurantesRepository.save(restaurante);
	}

	public void excluir(Long restauranteId) {
		try {
			restaurantesRepository.deleteById(restauranteId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe um cadastro de Restaurante com codigo %d", restauranteId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Restaurante de codigo %d nao pode ser removida, pois esta em uso", restauranteId));
		}
	}

}

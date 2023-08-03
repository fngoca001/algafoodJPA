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

	private static final String MSG_RESTAURANTE_EM_USO = "Restaurante de codigo %d nao pode ser removida, pois esta em uso";

	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Nao existe um cadastro de Restaurante com codigo %d";

	@Autowired
	private RestaurantesRepository restaurantesRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
				
		/*
		 * orElseThrow(() -> new EntidadeNaoEncontradaException(
		 * String.format("Nao existe cadastro de uma Cozinha de codigo %d",
		 * cozinhaId)));
		 */
		restaurante.setCozinha(cozinha);

		return restaurantesRepository.save(restaurante);
	}

	public void excluir(Long restauranteId) {
		try {
			restaurantesRepository.deleteById(restauranteId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_RESTAURANTE_EM_USO, restauranteId));
		}
	}

	public Restaurante buscarOuFalhar(Long restauranteId) {
		return restaurantesRepository.findById(restauranteId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
	}
}

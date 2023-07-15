package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhasRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhasRepository cozinhasRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhasRepository.save(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		
		try {
			cozinhasRepository.deleteById(cozinhaId);
		}
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Nao existe um cadastro de cozinha com codigo %d"
					, cozinhaId));
		}
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de codigo %d nao pode ser removida, pois esta em uso", cozinhaId));
		}
		
	}
}

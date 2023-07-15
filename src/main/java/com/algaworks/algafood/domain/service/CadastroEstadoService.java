package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.EstadosRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadosRepository estadosRepository;

	public Estado salvar(Estado estado) {
		return estadosRepository.save(estado);
	}

	public void excluir(Long estadoId) {

		try {
			estadosRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe um cadastro de Estado com codigo %d", estadoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de codigo %d nao pode ser removida, pois esta em uso", estadoId));
		}
	}
}

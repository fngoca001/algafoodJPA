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

	private static final String MSG_ESTADO_EM_USO = "Estado de codigo %d nao pode ser removida, pois esta em uso";
	private static final String MSG_ESTADO_NAO_ENCONTRADO = "Nao existe um cadastro de Estado com codigo %d";
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
					String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));
			
		} catch (DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(
					String.format(MSG_ESTADO_EM_USO, estadoId));
			
		}
	}

	public Estado buscarOuFalhar(Long estadoId) {
		return estadosRepository.findById(estadoId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId)));
	}
}

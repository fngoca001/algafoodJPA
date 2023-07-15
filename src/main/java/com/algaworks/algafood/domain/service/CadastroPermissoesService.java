package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.entity.Permissao;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.EstadosRepository;
import com.algaworks.algafood.domain.repository.PermissoesRepository;

@Service
public class CadastroPermissoesService {

	@Autowired
	private PermissoesRepository permissoesRepository;

	public Permissao salvar(Permissao permissao) {
		return permissoesRepository.save(permissao);
	}

	public void excluir(Long permissaoId) {

		try {
			permissoesRepository.deleteById(permissaoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe um cadastro de Estado com codigo %d", permissaoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de codigo %d nao pode ser removida, pois esta em uso", permissaoId));
		}
	}
}

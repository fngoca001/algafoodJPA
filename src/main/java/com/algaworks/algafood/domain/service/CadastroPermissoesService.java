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

	private static final String MSG_PERMISSAO_NAO_ENCOTRADA = "Permissao de codigo %d nao pode ser removida, pois esta em uso";
	private static final String MSG_PERMISSAO_NAO_ENCONTRADA = "Nao existe um cadastro de Permissao com codigo %d";
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
					String.format(MSG_PERMISSAO_NAO_ENCONTRADA, permissaoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_PERMISSAO_NAO_ENCOTRADA, permissaoId));
		}
	}

	public Permissao buscarOuFalhar(Long permissaoId) {
		return permissoesRepository.findById(permissaoId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_PERMISSAO_NAO_ENCONTRADA, permissaoId)));
	}
}

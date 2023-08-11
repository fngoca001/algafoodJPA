package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.repository.CidadesRepository;;

@Service
public class CadastroCidadeService {

	private static final String MSG_CIDADE_EM_USO = "Cidade de codigo %d nao pode ser removida, pois esta em uso";

	@Autowired
	private CidadesRepository cidadesRepository;

	@Autowired
	private CadastroEstadoService cadastroEstado;

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = cadastroEstado.buscarOuFalhar(estadoId);
	
		cidade.setEstado(estado);

		return cidadesRepository.save(cidade);
	}

	public void excluir(Long cidadeId) {
		try {
			cidadesRepository.deleteById(cidadeId);

		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradaException(cidadeId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_CIDADE_EM_USO, cidadeId));
		}
	}

	public Cidade buscarouFalhar(Long cidadeId) {
		return cidadesRepository.findById(cidadeId).orElseThrow(() 
				-> new CidadeNaoEncontradaException(cidadeId));
	}

}

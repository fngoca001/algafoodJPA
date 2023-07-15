package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CidadesRepository;
import com.algaworks.algafood.domain.repository.EstadosRepository;;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadesRepository cidadesRepository;
	
	@Autowired
	private EstadosRepository estadosRepository;

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadosRepository.findById(estadoId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Nao existe cadastro de uma Cozinha de codigo %d", estadoId)));

		cidade.setEstado(estado);

		return cidadesRepository.save(cidade);
	}

	public void excluir(Long cidadeId) {
		try {
			cidadesRepository.deleteById(cidadeId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe um cadastro de Restaurante com codigo %d", cidadeId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Restaurante de codigo %d nao pode ser removida, pois esta em uso", cidadeId));
		}
	}

}

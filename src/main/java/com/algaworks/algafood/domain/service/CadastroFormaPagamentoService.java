package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.entity.FormaPagamento;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.EstadosRepository;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {

	private static final String MSG_FORMA_PAGAMENTO_EM_USO = "Forma de Pagamento de codigo %d nao pode ser removida, pois esta em uso";
	private static final String MSG_FORMA_PAGAMENTO_NAO_ENCONTRADO = "Nao existe um cadastro de Forma de Pagamento com codigo %d";
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return formaPagamentoRepository.save(formaPagamento);
	}

	public void excluir(Long formaPagamentoId) {

		try {
			formaPagamentoRepository.deleteById(formaPagamentoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format(MSG_FORMA_PAGAMENTO_NAO_ENCONTRADO, formaPagamentoId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(
					MSG_FORMA_PAGAMENTO_EM_USO, formaPagamentoId));
		}
	}

	public FormaPagamento buscarOuFalhar(Long formaPagamentoId) {
		return formaPagamentoRepository.findById(formaPagamentoId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_FORMA_PAGAMENTO_NAO_ENCONTRADO, formaPagamentoId)));
	}
}

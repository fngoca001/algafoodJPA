package com.algaworks.algafood.domain.exception;

public class RestauranteNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public RestauranteNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public RestauranteNaoEncontradaException(Long estadoId) {
		this(String.format("Nao existe um cadastro de Restaurante com codigo %d", estadoId));
	}
}

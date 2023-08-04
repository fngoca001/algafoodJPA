package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Permissao;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.PermissoesRepository;
import com.algaworks.algafood.domain.service.CadastroPermissoesService;

@RestController
@RequestMapping("/permissoes")
public class PermissoesController {

	@Autowired
	private PermissoesRepository permissoesRepository;

	@Autowired
	private CadastroPermissoesService cadastroPermissoes;

	@GetMapping
	public List<Permissao> listar() {
		return permissoesRepository.findAll();
	}

	@GetMapping("/{permissoesId}")
	public ResponseEntity<Permissao> buscar(@PathVariable Long permissoesId) {
		Optional<Permissao> permissao = permissoesRepository.findById(permissoesId);
		if (permissao.isPresent()) {
			return ResponseEntity.ok(permissao.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Permissao adicionar(@RequestBody Permissao permissao) {
		return cadastroPermissoes.salvar(permissao);
	}

	/*
	 * @PutMapping("/{permissoesId}") public Permissao atualizar(@PathVariable Long
	 * permissoesId, @RequestBody Permissao permissao) { Permissao permissaoAtual =
	 * cadastroPermissoes.buscarOuFalhar(permissoesId);
	 * 
	 * BeanUtils.copyProperties(permissao, permissaoAtual, "id");
	 * 
	 * return cadastroPermissoes.salvar(permissaoAtual); }
	 * 
	 * @DeleteMapping("/{permissoesId}")
	 * 
	 * @ResponseStatus(value = HttpStatus.NO_CONTENT) public void
	 * remover(@PathVariable Long permissoesId) {
	 * cadastroPermissoes.excluir(permissoesId); }
	 */
}

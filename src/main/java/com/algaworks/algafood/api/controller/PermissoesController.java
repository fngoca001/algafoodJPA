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
	private CadastroPermissoesService cadastroPermissoesService;
	
	@GetMapping
	public List<Permissao> listar(){
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
		return permissoesRepository.save(permissao);
	}

	@PutMapping("/{permissoesId}")
	public ResponseEntity<Permissao> atualizar(@PathVariable Long permissoesId, @RequestBody Permissao permissao) {
		Optional<Permissao> permissaoAtual = permissoesRepository.findById(permissoesId);

		if (permissaoAtual.isPresent()) {
			BeanUtils.copyProperties(permissao, permissaoAtual.get(), "id");

			Permissao permissaoSalvar = cadastroPermissoesService.salvar(permissaoAtual.get());

			return ResponseEntity.ok(permissaoSalvar);
		}

		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{permissoesId}")
	public ResponseEntity<Permissao> remover(@PathVariable Long permissoesId) {
		try {
			cadastroPermissoesService.excluir(permissoesId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}
}

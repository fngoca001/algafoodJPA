package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhasRepository;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhasRepository cozinhasRepository;
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhasRepository.listar();	
		}
	
	@GetMapping("/{cozinhaid}")
	public Cozinha buscar(@PathVariable Long cozinhaid) {
		
		return cozinhasRepository.porId(cozinhaid);
	}
}

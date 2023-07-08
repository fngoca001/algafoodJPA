package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.repository.EstadosRepository;

@RestController
@RequestMapping("/estados")
public class EstaosController {

	@Autowired
	private EstadosRepository estadosRepository;
	
	@GetMapping
	public List<Estado> listar(){
		return estadosRepository.listar();
	}
}

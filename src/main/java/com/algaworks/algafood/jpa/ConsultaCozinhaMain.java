package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiJpaApplication;
import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhasRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiJpaApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhasRepository cozinhas = applicationContext.getBean(CozinhasRepository.class);

		List<Cozinha> cozinhaList = cozinhas.listar();

		for (Cozinha cozinha : cozinhaList) {

			System.out.println(cozinha.getNome());
		}
	}
}

package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiJpaApplication;
import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhasRepository;

public class InclusaoCozinha {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiJpaApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		CozinhasRepository cozinhas = applicationContext.getBean(CozinhasRepository.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Japonesa");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Brasileira");
		
		cozinhas.salvar(cozinha1);
		cozinhas.salvar(cozinha2);
		
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}
}

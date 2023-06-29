package com.algaworks.algafood.jpa;

import org.springframework.context.ApplicationContext;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algaworks.algafood.AlgafoodApiJpaApplication;
import com.algaworks.algafood.domain.entity.Cozinha;

public class InclusaoCozinha {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiJpaApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Japonesa");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Brasileira");
		
		cadastroCozinha.adiccoCozinha(cozinha1);
		cadastroCozinha.adiccoCozinha(cozinha2);
	}
}

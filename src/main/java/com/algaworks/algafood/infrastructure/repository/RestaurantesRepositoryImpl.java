package com.algaworks.algafood.infrastructure.repository;

import static com.algaworks.algafood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algaworks.algafood.infrastructure.repository.spec.RestauranteSpecs.comNomeCemeLhante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.repository.RestaurantesRepository;
import com.algaworks.algafood.domain.repository.RestaurantesRepositoryQueries;

@Repository
public class RestaurantesRepositoryImpl implements RestaurantesRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired @Lazy
	private RestaurantesRepository restaurantesRepository;

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFerteInicial, BigDecimal taxaFreteFinal) {

		/*
		 * var jpql = new StringBuilder(); jpql.append("from Restaurante where 0 = 0 ");
		 * 
		 * var parametros = new HashMap<String, Object>();
		 * 
		 * if (StringUtils.hasLength(nome)) {
		 * 
		 * jpql.append("and nome like :nome "); parametros.put("nome", "%" + nome +
		 * "%"); } if (taxaFerteInicial != null) {
		 * 
		 * jpql.append("and taxaFrete >= :taxaInicial "); parametros.put("taxaInicial",
		 * taxaFerteInicial); } if (taxaFreteFinal != null) {
		 * 
		 * jpql.append("and taxaFrete <= :taxaFinal"); parametros.put("taxaFinal",
		 * taxaFreteFinal); } // "and taxaFrete between :taxaInicial and :taxaFinal"
		 * 
		 * TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(),
		 * Restaurante.class);
		 * 
		 * parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
		 * return query.getResultList();
		 */

		var builder = manager.getCriteriaBuilder();
		
		var criteria = builder.createQuery(Restaurante.class);
		var root = criteria.from(Restaurante.class);//from restaurante
		
		var predicates = new ArrayList<Predicate>();
		
		if (StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		if (taxaFerteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFerteInicial));
		}
		
		if (taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		var query = manager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		return restaurantesRepository.findAll(comFreteGratis().and(comNomeCemeLhante(nome)));
	}
}

package com.algaworks.algafood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.algafood.Groups;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "Estado")
public class Estado {

	@NotNull(groups = Groups.EstadoId.class)
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
}

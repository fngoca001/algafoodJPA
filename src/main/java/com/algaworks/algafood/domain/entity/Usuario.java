package com.algaworks.algafood.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@ManyToMany
	@JoinTable(name = "grupo_usuario", 
			joinColumns = @JoinColumn(name = "grupo_id"), 
			inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Grupo> grupo = new ArrayList<>();
}

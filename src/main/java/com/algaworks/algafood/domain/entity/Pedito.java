package com.algaworks.algafood.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "pedido")
public class Pedito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sob_total")
	private BigDecimal sobTotal;
	
	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	@Column(name = "data_criacao")	
	private LocalDateTime dataCriacao;
	
	@Column(name = "data_confirmacao")
	private LocalDateTime dataConfirmacao;
	
	@Column(name = "data_cancelamento")
	private LocalDateTime dataCancelamento;
	
	@Column(name = "dataEntrega")
	private LocalDateTime dataEntrega;
	private Restaurante resta_erante;
	
	private FormaPagamento formaPagamento;
	
	private Usuario cliente;
}

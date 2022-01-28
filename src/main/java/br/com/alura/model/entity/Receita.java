package br.com.alura.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RECEITA")
public class Receita {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receita_id", nullable = false, unique = true, updatable = false)
	private Long receitaId;
	
	@Column(name = "receita_descricao", nullable = false)
	private String receitaDescricao;
	
	@Column(name = "receita_valor", nullable = false, scale = 2)
	private BigDecimal receitaValor;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "receita_data", nullable = false)
	private LocalDate receitaData;
	
	
}

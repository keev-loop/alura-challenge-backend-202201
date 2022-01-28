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
@Table(name = "DESPESA")
public class Despesa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "despesa_id", nullable = false)
	private Long despesaId;
	
	@Column(name = "despesa_descricao", nullable = false)
	private String despesaDescricao;
	
	@Column(name = "despesa_valor", nullable = false, scale = 2)
	private BigDecimal despesaValor;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "despesa_data", nullable = false)
	private LocalDate despesaData;

	@Column(name = "despesa_categoria", nullable = true)
	private String despesaCategoria = Categoria.OUTRAS.toString();
	
	
    public enum Categoria {
    	ALIMENTAÇÃO,
    	SAÚDE,
    	MORADIA,
    	TRANSPORTE,
    	EDUCAÇÃO,
    	LAZER,
    	IMPREVISTOS,
    	OUTRAS;
    }
	
}

package br.com.alura.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERFIL")
public class Perfil implements GrantedAuthority {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perfil_id", nullable = false, unique = true, updatable = false)
	private Long perfilId;
	
	@Column(name = "perfil_nome", nullable = false, unique = true)
	private String perfilNome;
	
	
	@Override
	public String getAuthority() {
		return perfilNome;
	}
	
	
}

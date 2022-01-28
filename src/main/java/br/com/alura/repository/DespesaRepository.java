package br.com.alura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.model.entity.Despesa;


@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	//Page<Despesa> findAll(Pageable paginacao);

}

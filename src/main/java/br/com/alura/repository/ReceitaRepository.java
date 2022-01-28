package br.com.alura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.model.entity.Receita;


@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}

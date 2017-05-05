package com.danielrocha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danielrocha.model.Servico;


public interface ServicoRepository extends JpaRepository<Servico, Long> {

	@Query("SELECT s FROM Servico s WHERE s.situacao = 'A'")
	List<Servico> findOnlyActives();
	
}
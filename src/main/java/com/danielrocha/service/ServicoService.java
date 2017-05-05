package com.danielrocha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielrocha.model.Servico;
import com.danielrocha.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;
	
	public List<Servico> findAll() {
		return repository.findAll(); 
	}
	
	public Servico findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Servico save(Servico servico) {
		return repository.saveAndFlush(servico);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Servico> findOnlyActives() {
		return repository.findOnlyActives(); 
	}
	
}
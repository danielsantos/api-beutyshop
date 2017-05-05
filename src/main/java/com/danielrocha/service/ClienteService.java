package com.danielrocha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielrocha.model.Cliente;
import com.danielrocha.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll(); 
	}
	
	public Cliente findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Cliente save(Cliente cliente) {
		return repository.saveAndFlush(cliente);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
}
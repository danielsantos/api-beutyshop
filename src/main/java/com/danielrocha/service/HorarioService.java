package com.danielrocha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielrocha.model.Horario;
import com.danielrocha.repository.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repository;
	
	public List<Horario> findAll() {
		return repository.findAll(); 
	}
	
	public Horario findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Horario save(Horario horario) {
		return repository.saveAndFlush(horario);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}

}
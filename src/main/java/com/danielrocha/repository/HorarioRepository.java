package com.danielrocha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielrocha.model.Horario;


public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
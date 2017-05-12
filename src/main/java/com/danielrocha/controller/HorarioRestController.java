package com.danielrocha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielrocha.model.Horario;
import com.danielrocha.service.HorarioService;

@RestController
public class HorarioRestController {

	@Autowired
    private HorarioService service;


    @RequestMapping("/horarios")
    public Iterable<Horario> listarTodos() {
        return service.findAll();
    }

    @RequestMapping("/horarios/{id}")
    public Horario listarPorId(@PathVariable String id) {
        return service.findOne(Long.parseLong(id));
    }

    @PostMapping(value="/horarios")
    public void inserir(@RequestBody Horario horario) {
        service.save(horario);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/horarios/{id}")
    public void atualizar(@RequestBody Horario horario, @PathVariable String id) {
        service.save(horario);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/horarios/{id}")
    public void excluir(@PathVariable String id) {
        service.delete(Long.parseLong(id));
    }
	
}

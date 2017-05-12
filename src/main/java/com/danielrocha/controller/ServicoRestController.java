package com.danielrocha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielrocha.model.Servico;
import com.danielrocha.service.ServicoService;

@RestController
public class ServicoRestController {

	@Autowired
    private ServicoService service;


    @RequestMapping("/servicos")
    public Iterable<Servico> listarTodos() {
        return service.findAll();
    }

    @RequestMapping("/servicos/{id}")
    public Servico listarPorId(@PathVariable String id) {
        return service.findOne(Long.parseLong(id));
    }

    @PostMapping(value="/servicos")
    public void inserir(@RequestBody Servico servico) {
        service.save(servico);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/servicos/{id}")
    public void atualizar(@RequestBody Servico servico, @PathVariable String id) {
        service.save(servico);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/servicos/{id}")
    public void excluir(@PathVariable String id) {
        service.delete(Long.parseLong(id));
    }
	
}

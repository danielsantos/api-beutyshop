package com.danielrocha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielrocha.model.Cliente;
import com.danielrocha.service.ClienteService;

@RestController
public class ClienteRestController {

	@Autowired
    private ClienteService service;


    @RequestMapping("/clientes")
    public Iterable<Cliente> listarTodos() {
        return service.findAll();
    }

    @RequestMapping("/clientes/{id}")
    public Cliente listarPorId(@PathVariable String id) {
        return service.findOne(Long.parseLong(id));
    }

    @PostMapping(value="/clientes")
    public void inserir(@RequestBody Cliente cliente) {
        service.save(cliente);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/clientes/{id}")
    public void atualizar(@RequestBody Cliente cliente, @PathVariable String id) {
        service.save(cliente);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/clientes/{id}")
    public void excluir(@PathVariable String id) {
        service.delete(Long.parseLong(id));
    }
	
}

package com.danielrocha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danielrocha.model.Cliente;
import com.danielrocha.service.ClienteService;

@RequestMapping("/clientes")
@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@GetMapping("/list")
	public ModelAndView findAll() {
		List<Cliente> lista = service.findAll();
		
		ModelAndView modelAndView = new ModelAndView("clientes");
		modelAndView.addObject("clientes", lista);
		
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Cliente cliente) {
		
		ModelAndView mv = new ModelAndView("/add");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(cliente);
		}
		
		service.save(cliente);
		
		return findAll();
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}
	
	/*
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}	
	*/
	
}
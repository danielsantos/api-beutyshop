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

import com.danielrocha.model.Servico;
import com.danielrocha.model.enumeration.TipoSituacao;
import com.danielrocha.service.ServicoService;

@RequestMapping("/servicos")
@Controller
public class ServicoController {
	
	@Autowired
	private ServicoService service;

	@GetMapping("/list")
	public ModelAndView findAll() {
		List<Servico> lista = service.findOnlyActives();
		
		ModelAndView modelAndView = new ModelAndView("views/servico/servicos");
		modelAndView.addObject("servicos", lista);
		
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Servico servico) {
		
		ModelAndView mv = new ModelAndView("views/servico/add");
		mv.addObject("servico", servico);
		
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Servico servico, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(servico);
		}
		
		service.save(servico);
		
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
	
	@GetMapping("/desativar/{id}")
	public ModelAndView desativar(@PathVariable("id") Long id) {

		Servico servico = service.findOne(id);
		servico.setSituacao(TipoSituacao.I);
		
		service.save(servico);
	
		return findAll();
	}
	
}
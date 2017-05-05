package com.danielrocha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danielrocha.model.Cliente;
import com.danielrocha.model.Horario;
import com.danielrocha.model.Servico;
import com.danielrocha.service.ClienteService;
import com.danielrocha.service.HorarioService;
import com.danielrocha.service.ServicoService;

@RequestMapping("/horarios")
@Controller
public class HorarioController {
	
	@Autowired
	private HorarioService service;
	
	@Autowired
	private ClienteService serviceCliente;
	
	@Autowired
	private ServicoService serviceServico;
	
	@GetMapping("/first")
	public ModelAndView listaClientes() {
		List<Cliente> lista = serviceCliente.findAll();
		
		ModelAndView modelAndView = new ModelAndView("views/horario/listaClientes");
		modelAndView.addObject("clientes", lista);
		
		return modelAndView;
	}
	
	@GetMapping("/second/{id}")
	public ModelAndView listaServicos(@PathVariable("id") Long id) {
		Cliente cliente = serviceCliente.findOne(id);
		List<Servico> servicos = serviceServico.findAll();
		
		ModelAndView modelAndView = new ModelAndView("views/horario/listaServicos");
		modelAndView.addObject("cliente", cliente);
		modelAndView.addObject("servicos", servicos);
		
		return modelAndView;
	}

	@RequestMapping(value="/finish", method=RequestMethod.POST)
	public void fecharHorario(@ModelAttribute Horario horario) {
		System.out.println("#################### : " + horario.getIdCliente());
		
	}

	@GetMapping("/list")
	public ModelAndView findAll() {
		List<Horario> lista = service.findAll();
		
		ModelAndView modelAndView = new ModelAndView("views/horario/horarios");
		modelAndView.addObject("horarios", lista);
		
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Horario horario) {
		
		ModelAndView mv = new ModelAndView("/servico/add");
		mv.addObject("horario", horario);
		
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Horario horario, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(horario);
		}
		
		service.save(horario);
		
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
package com.reciclap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reciclap.model.Empresa;
import com.reciclap.model.Material;
import com.reciclap.repository.EmpresaRepository;
import com.reciclap.repository.MaterialRepository;

@Controller
public class EmpresaController {

	@Autowired 
	EmpresaRepository er;
	
	@Autowired 
	MaterialRepository mr;
	
	@RequestMapping(value="/CadastraEmpresa", method=RequestMethod.GET)
	public String form(){
		return "empresa/formCadastroEmpresa";
	}

	@RequestMapping(value="/CadastraEmpresa", method=RequestMethod.POST)
	public String form(Empresa empresa){
		er.save(empresa);
		return "redirect:/Empresa"; 
	}
	
	@RequestMapping("/Empresa")
	public ModelAndView listaEmpresas(){
		ModelAndView mv = new ModelAndView("empresa/IndexEmpresa");
		Iterable<Empresa> empresas = er.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesEmpresa(@PathVariable("id") long id){
		Empresa empresa = er.findById(id);
		ModelAndView mv = new ModelAndView("empresa/detalhesEmpresa");
		mv.addObject("empresa",empresa);
		
		Iterable<Material> materiais = mr.findByEmpresa(empresa);
		mv.addObject("materiais", materiais);
		
		return mv;
	}
	
}

package com.reciclap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reciclap.model.Empresa;
import com.reciclap.model.Material;
import com.reciclap.repository.EmpresaRepository;
import com.reciclap.repository.MaterialRepository;

@Controller
public class EmpresaController {

	//repository
	@Autowired
	EmpresaRepository er;

	@Autowired
	MaterialRepository mr;

	//Cadastro de Empresas
	@RequestMapping(value = "/CadastraEmpresa", method = RequestMethod.GET)
	public String form() {
		return "empresa/formCadastroEmpresa";
	}

	@RequestMapping(value = "/CadastraEmpresa", method = RequestMethod.POST)
	public String form(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Todos os Campos São Obrigatorios");
			return "redirect:/CadastraEmpresa";
		}
		er.save(empresa);
		return "redirect:/Empresa";
	}

	//Lista de Empresas
	@RequestMapping("/Empresa")
	public ModelAndView listaEmpresas() {
		ModelAndView mv = new ModelAndView("empresa/IndexEmpresa");
		Iterable<Empresa> empresas = er.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}

	//Detalhes Empresa
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEmpresa(@PathVariable("id") long id) {
		Empresa empresa = er.findById(id);
		ModelAndView mv = new ModelAndView("empresa/detalhesEmpresa");
		mv.addObject("empresa", empresa);

		Iterable<Material> materiais = mr.findByEmpresa(empresa);
		mv.addObject("materiais", materiais);

		return mv;
	}

	// Deletar Empresa
	@RequestMapping("/deletar")
	public String deletarEmpresa(long id) {
		Empresa empresa = er.findById(id);
		er.delete(empresa);
		return "redirect:/Empresa";
	}

	// Editar Empresa
	@RequestMapping("Empresa/{id}")
	public ModelAndView updateEmpresa(@PathVariable("id") long id) {
		Empresa empresa = er.findById(id);
		ModelAndView mv = new ModelAndView("empresa/updateEmpresa");
		mv.addObject("empresa", empresa);
		return mv;
	}

	@RequestMapping(value = "Empresa/{id}", method = RequestMethod.POST)
	public String updateEmpresaPost(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Todos os Campos São Obrigatorios");
			return "redirect:/empresa/{id}";
		}
		er.save(empresa);
		return "redirect:/Empresa";
	}

}

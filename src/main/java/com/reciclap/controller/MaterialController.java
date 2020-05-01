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
public class MaterialController {

	// repository
	@Autowired
	EmpresaRepository er;

	@Autowired
	MaterialRepository mr;

	// lista de materiais
	@RequestMapping("/Material")
	public ModelAndView listaMateriais() {
		ModelAndView mv = new ModelAndView("material/indexMaterial");
		Iterable<Material> materiais = mr.findAll();
		mv.addObject("materiais", materiais);
		return mv;
	}

	// Cadastro de materiais
	@RequestMapping("/CadastraMaterial")
	public ModelAndView CadastraMaterial() {
		ModelAndView mv = new ModelAndView("material/formCadastroMaterial");
		Iterable<Empresa> empresas = er.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}

	@RequestMapping(value = "/CadastraMaterial", method = RequestMethod.POST)
	public String CadastraMaterial(Long id, @Valid Material material, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Todos os Campos São Obrigatorios");
			return "redirect:/CadastraMaterial";
		}

		Empresa empresa = er.findById(id);
		material.setEmpresa(empresa);
		mr.save(material);
		return "redirect:/Material";
	}

	// Deletar materiais
	@RequestMapping("/deletarmaterial")
	public String deletarMaterial(long id) {
		Material material = mr.findById(id);
		mr.delete(material);
		return "redirect:/Material";
	}

	// Editar Materiais
	@RequestMapping("material/{id}")
	public ModelAndView updateMaterial(@PathVariable("id") long id) {
		Material material = mr.findById(id);
		ModelAndView mv = new ModelAndView("material/updateMaterial");
		mv.addObject("material", material);
		Iterable<Empresa> empresas = er.findAll();
		mv.addObject("empresas", empresas);
		return mv;
	}

	@RequestMapping(value = "material/{id}", method = RequestMethod.POST)
	public String updateMaterialPost(long codigo, @Valid Material material, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Todos os Campos São Obrigatorios");
			return "redirect:/material/{id}";
		}
		Empresa empresa = er.findById(codigo);
		material.setEmpresa(empresa);
		mr.save(material);
		return "redirect:/Material";
	}

}

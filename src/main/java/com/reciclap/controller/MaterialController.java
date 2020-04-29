package com.reciclap.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reciclap.model.Empresa;
import com.reciclap.model.Material;
import com.reciclap.repository.EmpresaRepository;
import com.reciclap.repository.MaterialRepository;

@Controller
public class MaterialController {


		@Autowired 
		EmpresaRepository er;

		@Autowired 
		MaterialRepository mr;
		
		@RequestMapping("/Material")
		public ModelAndView listaMateriais(){
			ModelAndView mv = new ModelAndView("material/indexMaterial");
			Iterable<Material> materiais = mr.findAll();
			mv.addObject("materiais", materiais);
			return mv;
		}
		
		@RequestMapping("/CadastraMaterial")
		public ModelAndView CadastraMaterial(){
			ModelAndView mv = new ModelAndView("material/formCadastroMaterial");
			Iterable<Empresa> empresas = er.findAll();
			mv.addObject("empresas", empresas);
			return mv;
		}
		
		@RequestMapping(value="/CadastraMaterial", method=RequestMethod.POST)
		public String CadastraMaterial(Long id, Material material){
			Empresa empresa = er.findById(id);
			material.setEmpresa(empresa);
			mr.save(material);
			return "redirect:/Empresa";
		}


}

package com.reciclap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclap.model.Empresa;
import com.reciclap.model.Material;
import com.reciclap.repository.EmpresaRepository;
import com.reciclap.repository.MaterialRepository;

@RestController
@RequestMapping(value="/MaterialAPI")
public class MaterialAPI {

	@Autowired
	MaterialRepository mr;
	
	@Autowired
	EmpresaRepository er;
	
	@GetMapping("/materiais")
	public Iterable<Material> listaMateriais(){
		return  mr.findAll();
	}
	
	@GetMapping("/material/{id}")
	public Material materialId(@PathVariable (value="id") long id){
		return  mr.findById(id);
	}
	
	@PostMapping("/materialPost")
	public Material salvarMaterial(@RequestBody Material material){
		return mr.save(material);
	}
	
	@DeleteMapping("/materialDelete")
	public void deletaMaterial(@RequestBody Material material){
		mr.delete(material);
	}
	
}

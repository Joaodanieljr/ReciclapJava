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
import com.reciclap.repository.EmpresaRepository;


@RestController
@RequestMapping(value="/EmpresaAPI")
public class EmpresaAPI {

	@Autowired
	EmpresaRepository er;
	
	@GetMapping("/empresas")
	public Iterable<Empresa> listaEmpresa(){
		return  er.findAll();
	}
	
	@GetMapping("/empresa/{id}")
	public Empresa empresaId(@PathVariable (value="id") long id){
		return  er.findById(id);
	}
	
	@PostMapping("/empresaPost")
	public Empresa salvarEmpresa(@RequestBody Empresa empresa){
		return er.save(empresa);
	}
	
	@DeleteMapping("/empresaDelete")
	public void deletaEmpresa(@RequestBody Empresa empresa){
		er.delete(empresa);
	}
	
	
	
}

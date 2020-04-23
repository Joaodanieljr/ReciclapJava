package com.reciclap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpresaController {
	
	@RequestMapping("/CadastraEmpresa")
	public String form(){
		return "empresa/formCadastroEmpresa";
	}

}

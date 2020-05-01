package com.reciclap.repository;

import org.springframework.data.repository.CrudRepository;

import com.reciclap.model.Empresa;
import com.reciclap.model.Material;

public interface MaterialRepository extends CrudRepository<Material, String> {

	Iterable<Material> findByEmpresa(Empresa empresa);
	
	Material findById(long id);
}

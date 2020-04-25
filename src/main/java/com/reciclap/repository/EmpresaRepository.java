package com.reciclap.repository;

import org.springframework.data.repository.CrudRepository;

import com.reciclap.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, String> {

	Empresa findById(long id);
}

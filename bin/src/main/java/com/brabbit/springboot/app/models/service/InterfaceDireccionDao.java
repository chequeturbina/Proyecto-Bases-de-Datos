package com.brabbit.springboot.app.models.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.brabbit.springboot.app.models.entity.Direccion;

public interface InterfaceDireccionDao{
	
	public void save(Direccion direccion);

}

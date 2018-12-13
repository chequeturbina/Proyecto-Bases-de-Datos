package com.brabbit.springboot.app.models.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.Vehiculo;

public interface InterfaceVehiculoDao{
	
	public void save(Vehiculo vehiculo);

}

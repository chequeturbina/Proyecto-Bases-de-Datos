package com.brabbit.springboot.app.models.service;

import java.util.List;

import com.brabbit.springboot.app.models.entity.Destino;

public interface InterfaceDestinoDao{
	
	public void save(Destino destino);
	
	public List<Destino> findAll();

	public Destino findOne(long id);

}

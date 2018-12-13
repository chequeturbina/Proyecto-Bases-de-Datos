package com.brabbit.springboot.app.models.service;

import java.util.List;

import com.brabbit.springboot.app.models.entity.TipoGas;

public interface InterfaceTipoGasDao{
	
	public void save(TipoGas tipogas);
	
	public List<TipoGas> findAll();

	public TipoGas findOne(long id);


}

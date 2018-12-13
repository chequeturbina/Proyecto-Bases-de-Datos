package com.brabbit.springboot.app.models.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.entity.TipoUsuario;
import com.brabbit.springboot.app.models.entity.Vehiculo;

public interface InterfaceTipoCarroDao{
	
	public void save(TipoCarro tipocarro);
	
	public List<TipoCarro> findAll();

	public TipoCarro findOne(long id);

}

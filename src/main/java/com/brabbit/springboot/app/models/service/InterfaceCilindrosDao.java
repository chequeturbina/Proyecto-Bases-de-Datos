package com.brabbit.springboot.app.models.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.brabbit.springboot.app.models.entity.Cilindros;
import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.LlantaRefaccion;
import com.brabbit.springboot.app.models.entity.NPuertas;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.entity.Vehiculo;

public interface InterfaceCilindrosDao{
	
	public void save(Cilindros cilindros);
	
	public List<Cilindros> findAll();

	public Cilindros findOne(long id);

}

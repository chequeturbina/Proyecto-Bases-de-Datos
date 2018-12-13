package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.Vehiculo;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class VehiculoDaoImplement implements InterfaceVehiculoDao {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Override
	public void save(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		em.persist(vehiculo);

	}

	
}

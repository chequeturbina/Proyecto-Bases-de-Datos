package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.NPuertas;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.entity.Vehiculo;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class NPuertasDaoImplement implements InterfaceNPuertasDao {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Override
	public void save(NPuertas npuertas) {
		// TODO Auto-generated method stub
		em.persist(npuertas);

	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<NPuertas> findAll() {
		List tipos = em.createQuery("SELECT e FROM NPuertas e", NPuertas.class).getResultList();
		
		return tipos;
	}

	public NPuertas findOne(long tipo) {
		return em.find(NPuertas.class, tipo);
	}
	
}

package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.entity.Vehiculo;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class TipoGasDaoImplement implements InterfaceTipoGasDao {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Override
	public void save(TipoGas tipogas) {
		// TODO Auto-generated method stub
		em.persist(tipogas);

	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TipoGas> findAll() {
		List tipos = em.createQuery("SELECT e FROM TipoGas e", TipoGas.class).getResultList();
		
		return tipos;
	}

	public TipoGas findOne(long tipo) {
		return em.find(TipoGas.class, tipo);
	}

	
}

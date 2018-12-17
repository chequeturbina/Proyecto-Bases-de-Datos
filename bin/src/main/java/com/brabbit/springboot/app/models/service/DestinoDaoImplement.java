package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Destino;


@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class DestinoDaoImplement implements InterfaceDestinoDao {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Override
	public void save(Destino destino) {
		// TODO Auto-generated method stub
		em.persist(destino);

	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Destino> findAll() {
		List tipos = em.createQuery("SELECT e FROM Destino e", Destino.class).getResultList();
		return tipos;
	}

	public Destino findOne(long tipo) {
		return em.find(Destino.class, tipo);
	}
	
}

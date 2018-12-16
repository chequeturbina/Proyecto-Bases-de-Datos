package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Origen;


@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class OrigenDaoImplement implements InterfaceOrigenDao {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Override
	public void save(Origen origen) {
		// TODO Auto-generated method stub
		em.persist(origen);

	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Origen> findAll() {
		List tipos = em.createQuery("SELECT e FROM Origen e", Origen.class).getResultList();
		return tipos;
	}

	public Origen findOne(long tipo) {
		return em.find(Origen.class, tipo);
	}
	
}

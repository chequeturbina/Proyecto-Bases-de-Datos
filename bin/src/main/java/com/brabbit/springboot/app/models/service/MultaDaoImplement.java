package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Multa;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class MultaDaoImplement implements InterfaceMultaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public void save(Multa multa) {
		// TODO Auto-generated method stub
		em.persist(multa);
	}
	
	public List<Multa> listarMultas(){
		List<Multa> multas=em.createQuery("SELECT e FROM Multa e",Multa.class).getResultList();
		return multas;
	}

}

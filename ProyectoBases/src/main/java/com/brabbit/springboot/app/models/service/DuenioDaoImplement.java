package com.brabbit.springboot.app.models.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Chofer;
import com.brabbit.springboot.app.models.entity.Duenio;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class DuenioDaoImplement implements InterfaceDuenioDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void save(Duenio duenio) {
		// TODO Auto-generated method stub
		em.persist(duenio);

	}

	public Duenio porNombre(String rfc) {
		List<Duenio> results = em.createQuery("SELECT w FROM Duenio w WHERE w.rfc = :rfc", Duenio.class)
				.setParameter("rfc", rfc).getResultList();
		System.out.println(results);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<Duenio> listarDuenios(){
		List<Duenio> duenios=em.createQuery("SELECT e FROM Duenio e",Duenio.class).getResultList();
		return duenios;
	}


}

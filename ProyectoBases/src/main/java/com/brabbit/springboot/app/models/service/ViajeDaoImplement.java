package com.brabbit.springboot.app.models.service;

	
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Chofer;
import com.brabbit.springboot.app.models.entity.Duenio;
import com.brabbit.springboot.app.models.entity.Viaje;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class ViajeDaoImplement implements InterfaceViajeDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void save(Viaje viaje) {
		// TODO Auto-generated method stub
		em.persist(viaje);

	}
	
	public List<Viaje> listarViajes(){
		List<Viaje> viajes =em.createQuery("SELECT e FROM Viaje e", Viaje.class).getResultList();
		return viajes;
	}
	
	public Viaje porId(long id) {
		List<Viaje> results = em.createQuery("SELECT w FROM Viaje w WHERE w.ID_VIAJE = :id", Viaje.class)
				.setParameter("id", id).getResultList();
		System.out.println(results);
		return results.isEmpty() ? null : results.get(0);
	}
}

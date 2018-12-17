package com.brabbit.springboot.app.models.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Chofer;
import com.brabbit.springboot.app.models.entity.Duenio;
import com.brabbit.springboot.app.models.entity.Usuario;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class ChoferDaoImplement implements InterfaceChoferDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void save(Chofer chofer) {
		// TODO Auto-generated method stub
		em.persist(chofer);

	}

	public Chofer porLicencia(String licencia) {
		List<Chofer> results = em.createQuery("SELECT w FROM Chofer w WHERE w.licencia = :licencia", Chofer.class)
				.setParameter("licencia", licencia).getResultList();
		System.out.println(results);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Chofer porCorreo(String correo) {
		List<Chofer> results = em.createQuery("SELECT w FROM Chofer w WHERE w.correo = :correo", Chofer.class)
				.setParameter("correo", correo).getResultList();
		System.out.println(results);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<Chofer> listarChoferes(){
		List<Chofer> choferes=em.createQuery("SELECT e FROM Chofer e",Chofer.class).getResultList();
		return choferes;
	}
	
	@Transactional
	public void update(Integer gananciafinal,long id){
		
		Query query= em.createQuery("Update Chofer a Set a.ganancia = :gananciafinal WHERE a.ID_CHOFER = :id");
	       query.setParameter("gananciafinal", gananciafinal);
	       query.setParameter("id", id);
	       query.executeUpdate();
	   }
	
	@Transactional
	public void updateContador(Integer contadorchofer,long id){
		
		Query query= em.createQuery("Update Chofer a Set a.contadorchofer = :contadorchofer WHERE a.ID_CHOFER = :id");
	       query.setParameter("contadorchofer", contadorchofer);
	       query.setParameter("id", id);
	       query.executeUpdate();
	   }
	
	@Transactional
	public void updateBono(Integer bono,long id){
		
		Query query= em.createQuery("Update Chofer a Set a.bono = :bono WHERE a.ID_CHOFER = :id");
	       query.setParameter("bono", bono);
	       query.setParameter("id", id);
	       query.executeUpdate();
	   }

}

package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Cilindros;
import com.brabbit.springboot.app.models.entity.Direccion;
import com.brabbit.springboot.app.models.entity.NPuertas;
import com.brabbit.springboot.app.models.entity.TipoCarro;
import com.brabbit.springboot.app.models.entity.TipoGas;
import com.brabbit.springboot.app.models.entity.Vehiculo;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class CilindrosDaoImplement implements InterfaceCilindrosDao {

	@PersistenceContext
	private EntityManager em;


	@Transactional
	@Override
	public void save(Cilindros cilindros) {
		// TODO Auto-generated method stub
		em.persist(cilindros);

	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cilindros> findAll() {
		List tipos = em.createQuery("SELECT e FROM Cilindros e", Cilindros.class).getResultList();
		return tipos;
	}

	public Cilindros findOne(long tipo) {
		return em.find(Cilindros.class, tipo);
	}
	
}

package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.TipoUsuario;

@Repository
public class TipoUsuarioDaoImplement implements InterfaceTipoDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void save(TipoUsuario tipo_usuario) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TipoUsuario> findAll() {
		List tipos = em.createQuery("SELECT e FROM TipoUsuario e", TipoUsuario.class).getResultList();
		
		return tipos;
	}

	public TipoUsuario findOne(long tipo) {
		return em.find(TipoUsuario.class, tipo);
	}


}

package com.brabbit.springboot.app.models.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Chofer;
import com.brabbit.springboot.app.models.entity.Duenio;
import com.brabbit.springboot.app.models.entity.Usuario;

@Repository
@EntityScan("com.brabbit.springboot.app.models.entity")
public class UsuarioDaoImplement implements InterfaceUsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);

	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios=em.createQuery("SELECT e FROM Usuario e",Usuario.class).getResultList();
		return usuarios;
	}
	
	public Usuario porCorreo(String correo) {
		List<Usuario> results = em.createQuery("SELECT w FROM Usuario w WHERE w.correo = :correo", Usuario.class)
				.setParameter("correo", correo).getResultList();
		System.out.println(results);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Usuario porId(long id) {
		List<Usuario> results = em.createQuery("SELECT w FROM Usuario w WHERE w.ID_USUARIO = :id", Usuario.class)
				.setParameter("id", id).getResultList();
		return results.isEmpty() ? null : results.get(0);
	}

	@Transactional
	public void update(Integer contadorusuario,long id){
		
		Query query= em.createQuery("Update Usuario a Set a.contadorusuario = :contadorusuario WHERE a.ID_USUARIO = :id");
	       query.setParameter("contadorusuario", contadorusuario);
	       query.setParameter("id", id);
	       query.executeUpdate();
	   }



}

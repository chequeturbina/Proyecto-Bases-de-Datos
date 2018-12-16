package com.brabbit.springboot.app.models.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.brabbit.springboot.app.models.entity.Usuario;

public interface InterfaceUsuarioDao{
	
	public void save(Usuario usuario);
	
	@Transactional
	public void update(Integer contadorusuario,long id);
}

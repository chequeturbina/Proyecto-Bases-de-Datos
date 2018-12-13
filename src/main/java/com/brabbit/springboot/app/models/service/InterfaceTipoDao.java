package com.brabbit.springboot.app.models.service;

import java.util.List;

import com.brabbit.springboot.app.models.entity.TipoUsuario;

public interface InterfaceTipoDao {

	public void save(TipoUsuario tipo_usuario);

	public List<TipoUsuario> findAll();

	public TipoUsuario findOne(long id);

}

package com.brabbit.springboot.app.models.service;

import java.util.List;


import com.brabbit.springboot.app.models.entity.Origen;

public interface InterfaceOrigenDao{
	
	public void save(Origen origen);
	
	public List<Origen> findAll();

	public Origen findOne(long id);

}

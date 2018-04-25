package com.Blacat.Ouc.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {
	
	public Material findBySid(int sid);

}

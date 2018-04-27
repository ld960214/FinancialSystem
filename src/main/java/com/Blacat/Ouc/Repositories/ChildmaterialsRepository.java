package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Childmaterials;

public interface ChildmaterialsRepository extends CrudRepository<Childmaterials, Long> {
	public List<Childmaterials> findByMid(int mid);
	public Childmaterials findByCmid(int cmid);
}

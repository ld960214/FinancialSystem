package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Materials;

public interface MaterialsRepository  extends CrudRepository<Materials, Long>{
	public List<Materials> findBySubid(int subid);
	public Materials findByMid(int mid);
}

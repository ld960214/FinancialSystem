package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Devices;

public interface DevicesRepository extends CrudRepository<Devices, Long> {
	public List<Devices> findBySubid(int subid);
	public Devices findByDid(int did);
	
}

package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Trips;

public interface TripsRepository extends CrudRepository<Trips, Long> {
	public List<Trips> findBySubid(int subid);
	public Trips findByTid(int tid);
}

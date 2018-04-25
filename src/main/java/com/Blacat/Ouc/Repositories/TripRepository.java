package com.Blacat.Ouc.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {
	public Trip findBySid(int sid);

}

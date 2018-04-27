package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Conference;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {
	public List<Conference> findBySubid(int subid);
	public Conference findByCid(int cid);
}

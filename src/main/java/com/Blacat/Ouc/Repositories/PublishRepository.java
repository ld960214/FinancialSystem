package com.Blacat.Ouc.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Publish;

public interface PublishRepository extends CrudRepository<Publish, Long> {
	public Publish findBySid(int sid);

}

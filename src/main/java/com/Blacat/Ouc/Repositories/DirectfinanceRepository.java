package com.Blacat.Ouc.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Device;
import com.Blacat.Ouc.Entities.Directfinance;

public interface DirectfinanceRepository extends CrudRepository<Directfinance, Long> {
	public Directfinance findBySid(int sid);

}

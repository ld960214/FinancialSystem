package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Amountlimit;
import com.Blacat.Ouc.Entities.Device;

public interface DeviceRepository extends CrudRepository<Device,Long> {
	public List<Device> findBySid(int sid);

}

package com.Blacat.Ouc.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Amountlimit;
import com.Blacat.Ouc.Entities.Device;
import com.Blacat.Ouc.Repositories.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	public List<Device> findBySid(int sid) {
		List<Device> a = deviceRepository.findBySid(sid);
		return a;
	}

}

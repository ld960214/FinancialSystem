package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Device;
import com.Blacat.Ouc.Entities.Directfinance;
import com.Blacat.Ouc.Repositories.DirectfinanceRepository;

@Service
public class DirectfinanceService {
	
	@Autowired
	private DirectfinanceRepository directfinanceRepository;
	
	public Directfinance findBySid(int sid) {
		Directfinance a = directfinanceRepository.findBySid(sid);
		return a;
		
	}

}

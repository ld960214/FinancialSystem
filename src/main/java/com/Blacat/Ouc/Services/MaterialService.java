package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Material;
import com.Blacat.Ouc.Repositories.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	public Material findBySid(int sid) {
		Material a = materialRepository.findBySid(sid);
		return a;
	}

}

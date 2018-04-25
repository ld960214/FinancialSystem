package com.Blacat.Ouc.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Publishtype;
import com.Blacat.Ouc.Repositories.PublishtypeRepository;

@Service
public class PublishtypeService {
	
	@Autowired
	private PublishtypeRepository publishtypeRepository;
	
	
	public Publishtype findById(int id) {
		Optional<Publishtype> a = publishtypeRepository.findById((long) id);
		return a.get();
	}

}

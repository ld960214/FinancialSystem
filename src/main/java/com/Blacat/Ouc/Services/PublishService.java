package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Publish;
import com.Blacat.Ouc.Repositories.PublishRepository;

@Service
public class PublishService {
	@Autowired
	private PublishRepository publishRepository;
	
	public Publish findBySid(int sid) {
		Publish a = publishRepository.findBySid(sid);
		return a;
	}

}

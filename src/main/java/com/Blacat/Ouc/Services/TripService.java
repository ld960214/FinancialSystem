package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Trip;
import com.Blacat.Ouc.Repositories.TripRepository;
import com.Blacat.Ouc.Repositories.TriptypeRepository;

@Service
public class TripService {
	@Autowired
	private TripRepository tripRepository;
	
	public Trip findBySid(int sid) {
		Trip a = tripRepository.findBySid(sid);
		return a;
	}

}

package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Trips;

import com.Blacat.Ouc.Repositories.TripsRepository;

@Service
public class TripsService {
	@Autowired
	TripsRepository tripsRepository;
	
	public List<Trips> getTrips(int subid){
		return tripsRepository.findBySubid(subid);
	}
	
	public Trips getTrip(int tid){
		return tripsRepository.findByTid(tid);
	}
	
	@Transactional
	public boolean delTrip(int tid){
		Trips d=tripsRepository.findByTid(tid);
		if(d!=null){
			tripsRepository.delete(d);
			return true;
		}else return false;
	}
	
	@Transactional
	public Trips addTrip(Trips Trips){
		return tripsRepository.save(Trips);
	}
	
	@Transactional
	public List<Trips> addTrips(List<Trips> trips){
		Iterable<Trips> trips2 = tripsRepository.saveAll(trips);
		List<Trips> result = new ArrayList<Trips>();
		trips2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public List<Trips> upTrips(List<Trips> trips){
		Iterable<Trips> trips2 = tripsRepository.saveAll(trips);
		List<Trips> result = new ArrayList<Trips>();
		trips2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public int delTrips(List<Integer> Trips){
		List<Trips> dlist = new ArrayList<Trips>();
		Trips.forEach(a->{dlist.add(tripsRepository.findByTid(a));});
		dlist.forEach(a->{tripsRepository.delete(a);});
		return dlist.size();
	}
	
	@Transactional
	public boolean upTrip(Trips trips){
		Trips d= tripsRepository.save(trips);
		return d!=null;
	}
}

package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Conference;
import com.Blacat.Ouc.Repositories.ConferenceRepository;

@Service
public class ConferenceService {
	@Autowired
	ConferenceRepository conferenceRepository;
	
	public List<Conference> getConferences(int subid){
		return conferenceRepository.findBySubid(subid);
		
	}
	
	public Conference getConference(int cid){
		return conferenceRepository.findByCid(cid);
	}
	
	@Transactional
	public boolean delConference(int cid){
		Conference d=conferenceRepository.findByCid(cid);
		if(d!=null){
			conferenceRepository.delete(d);
			return true;
		}else return false;
	}
	
	@Transactional
	public Conference addConference(Conference conference){
		return conferenceRepository.save(conference);
	}
	
	@Transactional
	public List<Conference> addConferences(List<Conference> conference){
		Iterable<Conference> conference2 = conferenceRepository.saveAll(conference);
		List<Conference> result = new ArrayList<Conference>();
		conference2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public List<Conference> upConferences(List<Conference> conference){
		Iterable<Conference> conference2 = conferenceRepository.saveAll(conference);
		List<Conference> result = new ArrayList<Conference>();
		conference2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public int delConferences(List<Integer> Conference){
		List<Conference> dlist = new ArrayList<Conference>();
		Conference.forEach(a->{dlist.add(conferenceRepository.findByCid(a));});
		dlist.forEach(a->{conferenceRepository.delete(a);});
		return dlist.size();
	}
	
	@Transactional
	public boolean upConference(Conference Conference){
		Conference d= conferenceRepository.save(Conference);
		return d!=null;
	}
	
	
}

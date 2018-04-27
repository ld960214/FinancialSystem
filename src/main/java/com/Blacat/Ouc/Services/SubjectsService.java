package com.Blacat.Ouc.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Conference;
import com.Blacat.Ouc.Entities.Devices;
import com.Blacat.Ouc.Entities.Iptf;
import com.Blacat.Ouc.Entities.Materials;
import com.Blacat.Ouc.Entities.Subjects;
import com.Blacat.Ouc.Entities.Trips;
import com.Blacat.Ouc.Repositories.SubjectsRepository;

@Service
public class SubjectsService {
	@Autowired
	SubjectsRepository subjectsRepository;
	@Autowired
	DevicesService devicesServices;
	@Autowired
	ConferenceService conferenceService;
	@Autowired
	TripsService tripsService;
	@Autowired
	MaterialsService materialsService;
	@Autowired
	IptfService iptfService;
	
	public List<Subjects> getSubjects(int proid){
		 
		return subjectsRepository.findByProid(proid);
	}
	
	public Subjects getSubject(int subid){
		return subjectsRepository.findBySubid(subid);
	}
	
	
	@Transactional
	public Subjects addSubject(Subjects subjects){
		
		return subjectsRepository.save(subjects);
	}
	
	@Transactional
	public Boolean upSubject(Subjects subjects){
		Subjects s=subjectsRepository.save(subjects);
		if(s!=null){
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean delSubject(int subid){
		//device
		//
		//
		List<Devices> d = devicesServices.getDevices(subid);
		for(int i=0;i<d.size();i++){
			devicesServices.delDevice(d.get(i).getDid());
		}
		d = devicesServices.getDevices(subid);
		if(d.size()!=0) return false;
		//
		//conference
		//
		List<Conference> c = conferenceService.getConferences(subid);
		for(int i=0;i<c.size();i++){
			conferenceService.delConference(c.get(i).getCid());
		}
		c=conferenceService.getConferences(subid);
		if(c.size()!=0) return false;
		//
		//trip
		//
		List<Trips> t = tripsService.getTrips(subid);
		for(int i=0;i<t.size();i++){
			tripsService.delTrip(t.get(i).getTid());
		}
		t=tripsService.getTrips(subid);
		if(t.size()!=0) return false;
		//
		//material
		//
		List<Materials> m = materialsService.getMaterials(subid);
		for(int i=0;i<m.size();i++){
			materialsService.delMaterial(m.get(i).getMid());
		}
		m=materialsService.getMaterials(subid);
		if(m.size()!=0) return false;
		//
		//iptf
		//
		List<Iptf> ii = iptfService.getIptfs(subid);
		for(int i=0;i<ii.size();i++){
			iptfService.delIptf(ii.get(i).getIid());
		}
		ii=iptfService.getIptfs(subid);
		if(ii.size()!=0) return false;
		//
		//subject
		//
		Subjects subjects = subjectsRepository.findBySubid(subid);
		if(subjects!=null){
			subjectsRepository.delete(subjects);
			return true;
		}
		else return false;
	}
	
}

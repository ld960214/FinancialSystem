package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Devices;
import com.Blacat.Ouc.Repositories.DevicesRepository;

@Service
public class DevicesService {
	@Autowired
	DevicesRepository devicesRepository;
	
	public List<Devices> getDevices(int subid){
		return devicesRepository.findBySubid(subid);
		
	}
	
	public Devices getDevice(int did){
		return devicesRepository.findByDid(did);
	}
	
	@Transactional
	public boolean delDevice(int did){
		Devices d=devicesRepository.findByDid(did);
		if(d!=null){
			devicesRepository.delete(d);
			return true;
		}else return false;
	}
	
	@Transactional
	public Devices addDevice(Devices devices){
		return devicesRepository.save(devices);
	}
	
	@Transactional
	public List<Devices> addDevices(List<Devices> devices){
		Iterable<Devices> devices2 = devicesRepository.saveAll(devices);
		List<Devices> result = new ArrayList<Devices>();
		devices2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public List<Devices> upDevices(List<Devices> devices){
		Iterable<Devices> devices2 = devicesRepository.saveAll(devices);
		List<Devices> result = new ArrayList<Devices>();
		devices2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public int delDevices(List<Integer> devices){
		List<Devices> dlist = new ArrayList<Devices>();
		devices.forEach(a->{dlist.add(devicesRepository.findByDid(a));});
		dlist.forEach(a->{devicesRepository.delete(a);});
		return dlist.size();
	}
	
	@Transactional
	public boolean upDevice(Devices devices){
		Devices d= devicesRepository.save(devices);
		return d!=null;
	}
	
	
}

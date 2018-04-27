package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Childmaterials;
import com.Blacat.Ouc.Repositories.ChildmaterialsRepository;

@Service
public class ChildmaterialsService {
	@Autowired
	ChildmaterialsRepository childmaterialsRepository;
	
	public List<Childmaterials> getChildmaterials(int mid){
		return childmaterialsRepository.findByMid(mid);
		
	}
	
	public Childmaterials getChildmaterial(int cmid){
		return childmaterialsRepository.findByCmid(cmid);
	}
	
	@Transactional
	public boolean delChildmaterial(int cmid){
		Childmaterials m=childmaterialsRepository.findByCmid(cmid);
		if(m!=null){
			childmaterialsRepository.delete(m);
			return true;
		}else return false;
	}
	
	@Transactional
	public Childmaterials addChildmaterial(Childmaterials childmaterials){
		return childmaterialsRepository.save(childmaterials);
	}
	
	@Transactional
	public List<Childmaterials> addChildmaterials(List<Childmaterials> childmaterials){
		Iterable<Childmaterials> childmaterials2 = childmaterialsRepository.saveAll(childmaterials);
		List<Childmaterials> result = new ArrayList<Childmaterials>();
		childmaterials2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public List<Childmaterials> upChildmaterials(List<Childmaterials> childmaterials){
		Iterable<Childmaterials> childmaterials2 = childmaterialsRepository.saveAll(childmaterials);
		List<Childmaterials> result = new ArrayList<Childmaterials>();
		childmaterials2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public int delChildmaterials(List<Integer> childmaterials){
		List<Childmaterials> cmlist = new ArrayList<Childmaterials>();
		childmaterials.forEach(a->{cmlist.add(childmaterialsRepository.findByCmid(a));});
		cmlist.forEach(a->{childmaterialsRepository.delete(a);});
		return cmlist.size();
	}
	
	@Transactional
	public boolean upChildmaterial(Childmaterials childmaterials){
		Childmaterials m= childmaterialsRepository.save(childmaterials);
		return m!=null;
	}
	
	
}

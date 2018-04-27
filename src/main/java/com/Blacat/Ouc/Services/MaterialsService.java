package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Childmaterials;
import com.Blacat.Ouc.Entities.Materials;
import com.Blacat.Ouc.Repositories.MaterialsRepository;

@Service
public class MaterialsService {
	@Autowired
	MaterialsRepository materialsRepository;
	
	@Autowired
	ChildmaterialsService childmaterialsService;
	
	public List<Materials> getMaterials(int subid){
		return materialsRepository.findBySubid(subid);
		
	}
	
	public Materials getMaterial(int mid){
		return materialsRepository.findByMid(mid);
	}
	
	@Transactional
	public boolean delMaterial(int mid){
		Materials m=materialsRepository.findByMid(mid);
		if(m!=null){
			List<Childmaterials> cml=childmaterialsService.getChildmaterials(mid);
			List<Integer> cmli=new ArrayList<Integer>();
			cml.forEach(a->{cmli.add(a.getCmid());});
			childmaterialsService.delChildmaterials(cmli);
			materialsRepository.delete(m);
			return true;
		}else return false;
	}
	
	@Transactional
	public Materials addMaterial(Materials materials){
		return materialsRepository.save(materials);
	}
	
	@Transactional
	public List<Materials> addMaterials(List<Materials> materials){
		Iterable<Materials> materials2 = materialsRepository.saveAll(materials);
		List<Materials> result = new ArrayList<Materials>();
		materials2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public List<Materials> upMaterials(List<Materials> materials){
		Iterable<Materials> materials2 = materialsRepository.saveAll(materials);
		List<Materials> result = new ArrayList<Materials>();
		materials2.forEach(single->{result.add(single);});
		return result;
	}
	
	@Transactional
	public int delMaterials(List<Integer> materials){
		List<Materials> mlist = new ArrayList<Materials>();
		materials.forEach(a->{mlist.add(materialsRepository.findByMid(a));});
		mlist.forEach(a->{
			List<Childmaterials> cml=childmaterialsService.getChildmaterials(a.getMid());
			List<Integer> cmli=new ArrayList<Integer>();
			cml.forEach(b->{cmli.add(b.getCmid());});
			childmaterialsService.delChildmaterials(cmli);
			materialsRepository.delete(a);
		});
		return mlist.size();
	}
	
	@Transactional
	public boolean upMaterial(Materials materials){
		Materials m= materialsRepository.save(materials);
		return m!=null;
	}
	
	
}

package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.Repositories.ProjectsRepository;

@Service
public class ProjectsService {
	@Autowired
	ProjectsRepository projectsRepository;
	
	
	public List<Projects> getProjects(int userid){
		 
		return projectsRepository.findByUserid(userid);
	}
	
	public Projects getProject(int proid){
		return projectsRepository.findByProid(proid);
	}

	@Transactional
	public boolean addProject(Projects projects){
		
		Projects p =projectsRepository.save(projects);
		if(p!=null){
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean upProject(Projects projects){
		Projects p =projectsRepository.save(projects);
		if(p!=null){
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean delProject(int proid){
		Projects p =projectsRepository.findByProid(proid);
		if(p==null) return false;
		projectsRepository.delete(p);
		return true;
	}
}

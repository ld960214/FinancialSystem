package com.Blacat.Ouc.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.Entities.Subjects;
import com.Blacat.Ouc.Repositories.ProjectsRepository;
import com.Blacat.Ouc.Repositories.UserRepository;

@Service
public class ProjectsService {
	@Autowired
	ProjectsRepository projectsRepository;
	@Autowired
	SubjectsService subjectsService;
	
	public List<Projects> getProjects(int userid){
		 
		return projectsRepository.findByUserid(userid);
	}
	
	public Projects getProject(int proid){
		return projectsRepository.findByProid(proid);
	}

	@Transactional
	public Projects addProject(Projects projects){
		
		Projects p =projectsRepository.save(projects);
		return p;
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
		List<Subjects> subjects = subjectsService.getSubjects(proid);
		for(int i=0;i<subjects.size();i++){
			subjectsService.delSubject(subjects.get(i).getSubid());
		}
		subjects = subjectsService.getSubjects(proid);
		if(subjects.size()!=0) return false;
		Projects p =projectsRepository.findByProid(proid);
		if(p==null) return false;
		projectsRepository.delete(p);
		return true;
	}
	
}

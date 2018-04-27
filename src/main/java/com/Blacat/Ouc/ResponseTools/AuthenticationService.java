package com.Blacat.Ouc.ResponseTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.Entities.Subjects;
import com.Blacat.Ouc.Repositories.ProjectsRepository;
import com.Blacat.Ouc.Repositories.SubjectsRepository;

@Service
public class AuthenticationService {
	@Autowired
	ProjectsRepository projectsRepository;
	@Autowired
	SubjectsRepository subjectsRepository;
	
	public Boolean IfProject(int proid,int userid){
		Projects pro=projectsRepository.findByProid(proid);
		return pro.getUserid()==userid;
	}
	
	public Boolean IfSubject(int subid,int userid){
		Subjects sub = subjectsRepository.findBySubid(subid);
		return IfProject(sub.getProid(), userid);
	}
	
	
	
}

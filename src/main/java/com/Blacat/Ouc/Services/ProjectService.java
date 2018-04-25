package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Project;
import com.Blacat.Ouc.Repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project findByUserid(int userid){
		Project a = projectRepository.findByUserid(userid);
		return a;
		
	}

}

package com.Blacat.Ouc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Subject;
import com.Blacat.Ouc.Repositories.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	
	public Subject findByPid(int pid) {
		Subject a = subjectRepository.findByPid(pid);
		return a;
	}

}

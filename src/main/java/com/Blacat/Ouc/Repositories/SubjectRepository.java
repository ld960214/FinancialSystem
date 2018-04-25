package com.Blacat.Ouc.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
	
	public Subject findByPid(int pid);

}

package com.Blacat.Ouc.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	public Project findByUserid(int userid);

}

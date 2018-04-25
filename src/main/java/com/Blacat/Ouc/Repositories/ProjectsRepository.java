package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Projects;

public interface ProjectsRepository extends CrudRepository<Projects, Long> {
	public List<Projects> findByUserid(int userid);
	public Projects findByProid(int proid);
}

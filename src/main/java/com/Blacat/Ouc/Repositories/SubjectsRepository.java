package com.Blacat.Ouc.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.Entities.Subjects;

public interface SubjectsRepository extends CrudRepository<Subjects, Long> {
	public Subjects findBySubid(int subid);
	public List<Subjects> findByProid(int proid);
}

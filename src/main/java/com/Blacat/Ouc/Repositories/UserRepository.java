package com.Blacat.Ouc.Repositories;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import com.Blacat.Ouc.Entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findByUsername(String username);
	
	public User findByUsernameAndUserpassword(String username,String password);
	
	public User findByUserid(int id);
}

package com.Blacat.Ouc.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import com.Blacat.Ouc.Entities.User;
import com.Blacat.Ouc.Repositories.UserRepository;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepository;

	public Boolean IfExist(int userid) {
		User ul = userRepository.findByUserid(userid);
		if(ul==null) return false;
		else return true;
	}

	public Boolean IfExistByName(String username) {
		List<User> a = userRepository.findByUsername(username);
		if (a.size() != 0)
			return true;
		else
			return false;
	}

	public User findOne(int userid) {
		User ul = userRepository.findByUserid(userid);
		return ul;
	}

	public List<User> findAllByName(String username) {
		List<User> a = userRepository.findByUsername(username);

		return a;
	}

	@Transactional
	public Boolean addUser(User user) {
		if(IfExistByName(user.getUserName())){
		userRepository.save(user);
		return true;}
		else return false;
	}

	@Transactional
	public Boolean saveUser(User user) {
		if (IfExist(user.getUserid())) {
			userRepository.save(user);
			return true;
		}else return false;

	}


}

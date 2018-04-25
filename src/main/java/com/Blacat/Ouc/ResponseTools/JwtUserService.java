package com.Blacat.Ouc.ResponseTools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Blacat.Ouc.Entities.User;
import com.Blacat.Ouc.Repositories.UserRepository;

public class JwtUserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> user = userRepository.findByUsername(username);
		if(user.size()!=0){
			JwtUser juser = new JwtUser(user.get(0).getUserid(), user.get(0).getUserName(), "{noop}"+user.get(0).getUserPassword());
			return juser;
		}
		return null;
	}

}

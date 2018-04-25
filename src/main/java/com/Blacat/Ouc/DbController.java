package com.Blacat.Ouc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Blacat.Ouc.Repositories.UserRepository;

import com.Blacat.Ouc.Entities.User;

@Controller
@RequestMapping("/db")
public class DbController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String name,@RequestParam String password ){
		User n = new User();
		n.setUserName(name);
		n.setUserPassword(password);
		userRepository.save(n);
		
		return "Save";
	}
	
	@RequestMapping("/show")
	public @ResponseBody Iterable<User> show(){
		userRepository.findById((long)1);
		return userRepository.findAll();
	}
	
}

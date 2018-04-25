package com.Blacat.Ouc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blacat.Ouc.ConstNums;
import com.Blacat.Ouc.Entities.User;
import com.Blacat.Ouc.ResponseTools.ResponseData;
import com.Blacat.Ouc.ResponseTools.JwtUser;
import com.Blacat.Ouc.Services.UserService;


@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("user")
	public Object getUser(){
		HashMap<String, Object> mp = new HashMap<>();
		mp.put("fuck", "1");
		mp.put("stick", "2");
		return mp;
	}
	
	@PostMapping("user")
	public Object postUser(@RequestParam("username") String name,@RequestParam("userpassword") String password){
		if(userService.IfExistByName(name)) return new ResponseData(ConstNums.REGISTER_ERROR_APE,"用户名已存在",1,null);
		User user = new User(name,password);
		userService.addUser(user);
		if(userService.IfExistByName(name)) return new ResponseData(ConstNums.REGISTER_OK,"注册成功",1,null);
		return new ResponseData(ConstNums.REGISTER_ERROR_SERVER, "注册失败", 1, null);
	}
	
	@PutMapping("user")
	public Object postUser(@RequestBody Map<String,Object> data){
		
		User user = new User((int)data.get("userid"),(String)data.get("username"),(String)data.get("userpassword"));
		
		if(userService.IfExist(user.getUserid())){
			if(userService.saveUser(user))return new ResponseData(ConstNums.REGISTER_OK, "用户修改成功", 1, null);
			else return new ResponseData(ConstNums.REGISTER_ERROR_SERVER, "用户修改失败", 1, null);
		
		}else {
			return new ResponseData(ConstNums.REGISTER_ERROR_APE, "该用户不存在", 1, null);
		}
	}
	
	@GetMapping("test")
	public Object getTest(){
		return new ResponseData(1, "你看到我了", 1, null);
	}
	
}

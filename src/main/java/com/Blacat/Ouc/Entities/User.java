package com.Blacat.Ouc.Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int userid;
	
	
	private String username;
	
	
	private String userpassword;

	

	

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getUserPassword() {
		return userpassword;
	}

	public void setUserPassword(String userPassword) {
		this.userpassword = userPassword;
	}

	public User(){
		
	}
	
	
	
	public User(int userid, String username, String userpassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
	}

	public User(String username, String userpassword) {
		super();
		this.username = username;
		this.userpassword = userpassword;
	}



	
	
	

}

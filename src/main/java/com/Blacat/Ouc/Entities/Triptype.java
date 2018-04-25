package com.Blacat.Ouc.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Triptype {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ttid;
	
	private String ttname;
	
	private String ttdes;

	public int getTtid() {
		return ttid;
	}

	public void setTtid(int ttid) {
		this.ttid = ttid;
	}

	public String getTtname() {
		return ttname;
	}

	public void setTtname(String ttname) {
		this.ttname = ttname;
	}

	public String getTtdes() {
		return ttdes;
	}

	public void setTtdes(String ttdes) {
		this.ttdes = ttdes;
	}
	
	

}

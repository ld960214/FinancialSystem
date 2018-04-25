package com.Blacat.Ouc.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publishtype {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ptid;
	
	private String ptname;
	
	private String ptdes;

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public String getPtname() {
		return ptname;
	}

	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	public String getPtdes() {
		return ptdes;
	}

	public void setPtdes(String ptdes) {
		this.ptdes = ptdes;
	}
	
	
}

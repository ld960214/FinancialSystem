package com.Blacat.Ouc.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int puid;
	
	private int punum;
	
	private String pudes;
	
	private int ptid;
	
	private int sid;

	public int getPuid() {
		return puid;
	}

	public void setPuid(int puid) {
		this.puid = puid;
	}

	public int getPunum() {
		return punum;
	}

	public void setPunum(int punum) {
		this.punum = punum;
	}

	public String getPudes() {
		return pudes;
	}

	public void setPudes(String pudes) {
		this.pudes = pudes;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	

}

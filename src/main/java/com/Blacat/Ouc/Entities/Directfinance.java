package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Directfinance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int directid;
	
	private int typeid;
	
	private double totalfinance;
	
	private double specialfinance;
	
	private double selffinance;
	
	private int sid;

	public int getDirectid() {
		return directid;
	}

	public void setDirectid(int directid) {
		this.directid = directid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public double getTotalfinance() {
		return totalfinance;
	}

	public void setTotalfinance(double totalfinance) {
		this.totalfinance = totalfinance;
	}

	public double getSpecialfinance() {
		return specialfinance;
	}

	public void setSpecialfinance(double specialfinance) {
		this.specialfinance = specialfinance;
	}

	public double getSelffinance() {
		return selffinance;
	}

	public void setSelffinance(double selffinance) {
		this.selffinance = selffinance;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}

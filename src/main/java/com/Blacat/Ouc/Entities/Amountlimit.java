package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amountlimit {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int aid;
	
	private double aestinatefinance;
	
	private double aactualfinance;
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public double getAestinatefinance() {
		return aestinatefinance;
	}

	public void setAestinatefinance(double aestinatefinance) {
		this.aestinatefinance = aestinatefinance;
	}

	public double getAactualfinance() {
		return aactualfinance;
	}

	public void setAactualfinance(double aactualfinance) {
		this.aactualfinance = aactualfinance;
	}

	public double getSid() {
		return sid;
	}

	public void setSid(double sid) {
		this.sid = sid;
	}

	public double getTypeid() {
		return typeid;
	}

	public void setTypeid(double typeid) {
		this.typeid = typeid;
	}

	private double sid;
	
	private double typeid;
	

}

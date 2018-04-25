package com.Blacat.Ouc.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	private String subjectname;
	
	private double sestimatefinance;
	
	private double sactualfinance;
	
	private double aspecialfinance;
	
	private double selffinance;
	
	private double stotalfinance;
	
	private double directfinance;
	
	private int pid;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public double getSestimatefinance() {
		return sestimatefinance;
	}

	public void setSestimatefinance(double sestimatefinance) {
		this.sestimatefinance = sestimatefinance;
	}

	public double getSactualfinance() {
		return sactualfinance;
	}

	public void setSactualfinance(double sactualfinance) {
		this.sactualfinance = sactualfinance;
	}

	public double getAspecialfinance() {
		return aspecialfinance;
	}

	public void setAspecialfinance(double aspecialfinance) {
		this.aspecialfinance = aspecialfinance;
	}

	public double getSelffinance() {
		return selffinance;
	}

	public void setSelffinance(double selffinance) {
		this.selffinance = selffinance;
	}

	public double getStotalfinance() {
		return stotalfinance;
	}

	public void setStotalfinance(double stotalfinance) {
		this.stotalfinance = stotalfinance;
	}

	public double getDirectfinance() {
		return directfinance;
	}

	public void setDirectfinance(double directfinance) {
		this.directfinance = directfinance;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
}

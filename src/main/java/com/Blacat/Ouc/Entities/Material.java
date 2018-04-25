package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int mid;
	
	private String mname; 
	
	private int mnum;
	
	private double mprice;
	
	private double mtotal;
	
	private String mpurposer;
	
	private String mparameter;
	
	private String mbasis;
	
	private int sid;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public double getMprice() {
		return mprice;
	}

	public void setMprice(double mprice) {
		this.mprice = mprice;
	}

	public double getMtotal() {
		return mtotal;
	}

	public void setMtotal(double mtotal) {
		this.mtotal = mtotal;
	}

	public String getMpurposer() {
		return mpurposer;
	}

	public void setMpurposer(String mpurposer) {
		this.mpurposer = mpurposer;
	}

	public String getMparameter() {
		return mparameter;
	}

	public void setMparameter(String mparameter) {
		this.mparameter = mparameter;
	}

	public String getMbasis() {
		return mbasis;
	}

	public void setMbasis(String mbasis) {
		this.mbasis = mbasis;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}

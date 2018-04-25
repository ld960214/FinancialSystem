package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proid;
	
	private String proname;
	
	private int protype;
	
	private int userid;

	/**
	 * @return the proid
	 */
	public int getProid() {
		return proid;
	}

	/**
	 * @param proid the proid to set
	 */
	public void setProid(int proid) {
		this.proid = proid;
	}

	/**
	 * @return the proname
	 */
	public String getProname() {
		return proname;
	}

	/**
	 * @param proname the proname to set
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}

	

	/**
	 * @return the protype
	 */
	public int getProtype() {
		return protype;
	}

	/**
	 * @param protype the protype to set
	 */
	public void setProtype(int protype) {
		this.protype = protype;
	}

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


	public Projects() {
		super();
	}

	public Projects(String proname, int protype, int userid) {
		super();
		this.proname = proname;
		this.protype = protype;
		this.userid = userid;
	}

	public Projects(int proid, String proname, int protype, int userid) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.protype = protype;
		this.userid = userid;
	}
	
	
	
}

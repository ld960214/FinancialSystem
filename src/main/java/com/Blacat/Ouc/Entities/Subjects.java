package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subjects {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subid;
	
	private String subname;
	
	private int subtype;
	
	private int proid;

	/**
	 * @return the subid
	 */
	public int getSubid() {
		return subid;
	}

	/**
	 * @param subid the subid to set
	 */
	public void setSubid(int subid) {
		this.subid = subid;
	}

	/**
	 * @return the subname
	 */
	public String getSubname() {
		return subname;
	}

	/**
	 * @param subname the subname to set
	 */
	public void setSubname(String subname) {
		this.subname = subname;
	}

	/**
	 * @return the subtype
	 */
	public int getSubtype() {
		return subtype;
	}

	/**
	 * @param subtype the subtype to set
	 */
	public void setSubtype(int subtype) {
		this.subtype = subtype;
	}

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

	public Subjects() {
		super();
	}
	
	
}

package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Childmaterials {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cmid;
	
	private String cmname;
	
	private int cmamount;
	
	private int cmperprice;
	
	private int mid;

	
	/**
	 * @return the cmid
	 */
	public int getCmid() {
		return cmid;
	}

	/**
	 * @param cmid the cmid to set
	 */
	public void setCmid(int cmid) {
		this.cmid = cmid;
	}

	/**
	 * @return the cmname
	 */
	public String getCmname() {
		return cmname;
	}

	/**
	 * @param cmname the cmname to set
	 */
	public void setCmname(String cmname) {
		this.cmname = cmname;
	}

	/**
	 * @return the cmamount
	 */
	public int getCmamount() {
		return cmamount;
	}

	/**
	 * @param cmamount the cmamount to set
	 */
	public void setCmamount(int cmamount) {
		this.cmamount = cmamount;
	}

	/**
	 * @return the cmperprice
	 */
	public int getCmperprice() {
		return cmperprice;
	}

	/**
	 * @param cmperprice the cmperprice to set
	 */
	public void setCmperprice(int cmperprice) {
		this.cmperprice = cmperprice;
	}

	/**
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	

}

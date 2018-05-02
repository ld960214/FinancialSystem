package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Devices {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int did;
	
	private String introduction;
	
	private String dname;
	
	private int unitprice;
	
	private int damount;
	
	private String dtype;
	
	private int subid;

	/**
	 * @return the did
	 */
	public int getDid() {
		return did;
	}

	/**
	 * @param did the did to set
	 */
	public void setDid(int did) {
		this.did = did;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * @return the unitprice
	 */
	public int getUnitprice() {
		return unitprice;
	}

	/**
	 * @param unitprice the unitprice to set
	 */
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	/**
	 * @return the dtype
	 */
	public String getDtype() {
		return dtype;
	}

	/**
	 * @param dtype the dtype to set
	 */
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

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
	 * @return the damount
	 */
	public int getDamount() {
		return damount;
	}

	/**
	 * @param damount the damount to set
	 */
	public void setDamount(int damount) {
		this.damount = damount;
	}

	
}

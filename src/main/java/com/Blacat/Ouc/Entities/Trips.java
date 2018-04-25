package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trips {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	
	private String tname;
	
	private String tdes;
	
	private int tdays;
	
	private int tamount;
	
	private int tperprice;
	
	private int tallowance;
	
	private int subid;

	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}

	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	/**
	 * @return the tdes
	 */
	public String getTdes() {
		return tdes;
	}

	/**
	 * @param tdes the tdes to set
	 */
	public void setTdes(String tdes) {
		this.tdes = tdes;
	}

	/**
	 * @return the tdays
	 */
	public int getTdays() {
		return tdays;
	}

	/**
	 * @param tdays the tdays to set
	 */
	public void setTdays(int tdays) {
		this.tdays = tdays;
	}

	/**
	 * @return the tamount
	 */
	public int getTamount() {
		return tamount;
	}

	/**
	 * @param tamount the tamount to set
	 */
	public void setTamount(int tamount) {
		this.tamount = tamount;
	}

	/**
	 * @return the tperprice
	 */
	public int getTperprice() {
		return tperprice;
	}

	/**
	 * @param tperprice the tperprice to set
	 */
	public void setTperprice(int tperprice) {
		this.tperprice = tperprice;
	}

	/**
	 * @return the tallowance
	 */
	public int getTallowance() {
		return tallowance;
	}

	/**
	 * @param tallowance the tallowance to set
	 */
	public void setTallowance(int tallowance) {
		this.tallowance = tallowance;
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
	
	
}

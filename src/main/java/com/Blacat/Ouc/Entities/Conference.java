package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conference {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	
	private String cname;
	
	private String ctopic;
	
	private String ctime;
	
	private int cdays;
	
	private int cperprice;
	
	private int camount;
	
	private String cdes;
	
	private int subid;

	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the ctopic
	 */
	public String getCtopic() {
		return ctopic;
	}

	/**
	 * @param ctopic the ctopic to set
	 */
	public void setCtopic(String ctopic) {
		this.ctopic = ctopic;
	}

	/**
	 * @return the ctime
	 */
	public String getCtime() {
		return ctime;
	}

	/**
	 * @param ctime the ctime to set
	 */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	/**
	 * @return the cdays
	 */
	public int getCdays() {
		return cdays;
	}

	/**
	 * @param cdays the cdays to set
	 */
	public void setCdays(int cdays) {
		this.cdays = cdays;
	}

	/**
	 * @return the camount
	 */
	public int getCamount() {
		return camount;
	}

	/**
	 * @param camount the camount to set
	 */
	public void setCamount(int camount) {
		this.camount = camount;
	}

	/**
	 * @return the cdes
	 */
	public String getCdes() {
		return cdes;
	}

	/**
	 * @param cdes the cdes to set
	 */
	public void setCdes(String cdes) {
		this.cdes = cdes;
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

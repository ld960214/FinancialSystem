package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Iptf {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iid;
	
	private String iname;
	
	private String ides;
	
	private int iperprice;
	
	private int iamount;
	
	private int subid;
	
	

	/**
	 * @return the iid
	 */
	public int getIid() {
		return iid;
	}

	/**
	 * @param iid the iid to set
	 */
	public void setIid(int iid) {
		this.iid = iid;
	}

	/**
	 * @return the iname
	 */
	public String getIname() {
		return iname;
	}

	/**
	 * @param iname the iname to set
	 */
	public void setIname(String iname) {
		this.iname = iname;
	}

	/**
	 * @return the ides
	 */
	public String getIdes() {
		return ides;
	}

	/**
	 * @param ides the ides to set
	 */
	public void setIdes(String ides) {
		this.ides = ides;
	}

	/**
	 * @return the iperprice
	 */
	public int getIperprice() {
		return iperprice;
	}

	/**
	 * @param iperprice the iperprice to set
	 */
	public void setIperprice(int iperprice) {
		this.iperprice = iperprice;
	}

	/**
	 * @return the iamount
	 */
	public int getIamount() {
		return iamount;
	}

	/**
	 * @param iamount the iamount to set
	 */
	public void setIamount(int iamount) {
		this.iamount = iamount;
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

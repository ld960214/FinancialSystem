package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materials {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;
	
	private String maname;
	
	private String mdes;
	
	private int subid;

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

	/**
	 * @return the maname
	 */
	public String getManame() {
		return maname;
	}

	/**
	 * @param maname the maname to set
	 */
	public void setManame(String maname) {
		this.maname = maname;
	}

	/**
	 * @return the mdes
	 */
	public String getMdes() {
		return mdes;
	}

	/**
	 * @param mdes the mdes to set
	 */
	public void setMdes(String mdes) {
		this.mdes = mdes;
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

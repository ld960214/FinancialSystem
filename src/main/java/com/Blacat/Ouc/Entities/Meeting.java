package com.Blacat.Ouc.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int meid;
	
	private String mename;
	
	private String mecontent;
	
	private Timestamp medate;
	
	private int medays;
	
	private int mepnum;
	
	private String medes;
	
	private String metotaldes;
	
	public int getMeid() {
		return meid;
	}

	public void setMeid(int meid) {
		this.meid = meid;
	}

	public String getMename() {
		return mename;
	}

	public void setMename(String mename) {
		this.mename = mename;
	}

	public String getMecontent() {
		return mecontent;
	}

	public void setMecontent(String mecontent) {
		this.mecontent = mecontent;
	}

	public Timestamp getMedate() {
		return medate;
	}

	public void setMedate(Timestamp medate) {
		this.medate = medate;
	}

	public int getMedays() {
		return medays;
	}

	public void setMedays(int medays) {
		this.medays = medays;
	}

	public int getMepnum() {
		return mepnum;
	}

	public void setMepnum(int mepnum) {
		this.mepnum = mepnum;
	}

	public String getMedes() {
		return medes;
	}

	public void setMedes(String medes) {
		this.medes = medes;
	}

	public String getMetotaldes() {
		return metotaldes;
	}

	public void setMetotaldes(String metotaldes) {
		this.metotaldes = metotaldes;
	}


}

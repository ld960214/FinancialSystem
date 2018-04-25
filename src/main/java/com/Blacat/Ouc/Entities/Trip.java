package com.Blacat.Ouc.Entities;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int trid;
	
	private int trdays;
	
	private int trpnum;
	
	private int trcitynum;
	
	private String trdes;
	
	private String trdestotal;
	
	private int sid;
	
	private int meid;
	
	private int ttid;

	public int getTrid() {
		return trid;
	}

	public void setTrid(int trid) {
		this.trid = trid;
	}

	public int getTrdays() {
		return trdays;
	}

	public void setTrdays(int trdays) {
		this.trdays = trdays;
	}

	public int getTrpnum() {
		return trpnum;
	}

	public void setTrpnum(int trpnum) {
		this.trpnum = trpnum;
	}

	public int getTrcitynum() {
		return trcitynum;
	}

	public void setTrcitynum(int trcitynum) {
		this.trcitynum = trcitynum;
	}

	public String getTrdes() {
		return trdes;
	}

	public void setTrdes(String trdes) {
		this.trdes = trdes;
	}

	public String getTrdestotal() {
		return trdestotal;
	}

	public void setTrdestotal(String trdestotal) {
		this.trdestotal = trdestotal;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getMeid() {
		return meid;
	}

	public void setMeid(int meid) {
		this.meid = meid;
	}

	public int getTtid() {
		return ttid;
	}

	public void setTtid(int ttid) {
		this.ttid = ttid;
	}
	
	
	

}

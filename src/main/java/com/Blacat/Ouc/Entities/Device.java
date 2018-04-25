package com.Blacat.Ouc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int did;
	
	private String devicename;
	
	private String deviceversion;
	
	private double deviceprice;
	
	private int devicenum;
	
	private double dtotalfinance;
	
	private String dpurpose;
	
	private String dparameter;
	
	private String dbassis;
	
	private int sid;
	
	private int typeid;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getDeviceversion() {
		return deviceversion;
	}

	public void setDeviceversion(String deviceversion) {
		this.deviceversion = deviceversion;
	}

	public double getDeviceprice() {
		return deviceprice;
	}

	public void setDeviceprice(double deviceprice) {
		this.deviceprice = deviceprice;
	}

	public int getDevicenum() {
		return devicenum;
	}

	public void setDevicenum(int devicenum) {
		this.devicenum = devicenum;
	}

	public double getDtotalfinance() {
		return dtotalfinance;
	}

	public void setDtotalfinance(double dtotalfinance) {
		this.dtotalfinance = dtotalfinance;
	}

	public String getDpurpose() {
		return dpurpose;
	}

	public void setDpurpose(String dpurpose) {
		this.dpurpose = dpurpose;
	}

	public String getDparameter() {
		return dparameter;
	}

	public void setDparameter(String dparameter) {
		this.dparameter = dparameter;
	}

	public String getDbassis() {
		return dbassis;
	}

	public void setDbassis(String dbassis) {
		this.dbassis = dbassis;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	} 
	
	
	
}

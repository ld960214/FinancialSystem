package com.Blacat.Ouc.ResponseTools;


public class ResponseData {
	private int rescode;
	
	private String resString;
	
	private int resnum;
	
	private Object data;
	
	

	public ResponseData(int rescode, String resString, int resnum, Object data) {
		super();
		this.rescode = rescode;
		this.resString = resString;
		this.resnum = resnum;
		this.data = data;
	}

	/**
	 * @return the rescode
	 */
	public int getRescode() {
		return rescode;
	}

	/**
	 * @param rescode the rescode to set
	 */
	public void setRescode(int rescode) {
		this.rescode = rescode;
	}

	/**
	 * @return the resString
	 */
	public String getResString() {
		return resString;
	}

	/**
	 * @param resString the resString to set
	 */
	public void setResString(String resString) {
		this.resString = resString;
	}

	/**
	 * @return the resnum
	 */
	public int getResnum() {
		return resnum;
	}

	/**
	 * @param resnum the resnum to set
	 */
	public void setResnum(int resnum) {
		this.resnum = resnum;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	
	

	
	
	
	

}

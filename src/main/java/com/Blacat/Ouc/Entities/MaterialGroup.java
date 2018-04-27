package com.Blacat.Ouc.Entities;

import java.util.List;

public class MaterialGroup {
	private Materials ma;
	private List<Childmaterials> cm;
	public MaterialGroup(Materials ma, List<Childmaterials> cm) {
		super();
		this.ma = ma;
		this.cm = cm;
	}
	public MaterialGroup(){}
	/**
	 * @return the ma
	 */
	public Materials getMa() {
		return ma;
	}
	/**
	 * @param ma the ma to set
	 */
	public void setMa(Materials ma) {
		this.ma = ma;
	}
	/**
	 * @return the cm
	 */
	public List<Childmaterials> getCm() {
		return cm;
	}
	/**
	 * @param cm the cm to set
	 */
	public void setCm(List<Childmaterials> cm) {
		this.cm = cm;
	}
	
	
}

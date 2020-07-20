package com.oracle.entity;

public class Dstock {
	private int dId;
	private String dName;
	private double dStock;

	public Dstock() {
		super();
	}

	public Dstock(int dId, String dName, double dStock) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dStock = dStock;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public double getdStock() {
		return dStock;
	}

	public void setdStock(double dStock) {
		this.dStock = dStock;
	}

}

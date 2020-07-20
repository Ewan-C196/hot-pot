package com.oracle.entity;

public class Uvip {
	private int uId;
	private int uVip;
	private String vipStart;

	public Uvip() {
		super();
	}

	public Uvip(int uId, int uVip, String vipStart) {
		super();
		this.uId = uId;
		this.uVip = uVip;
		this.vipStart = vipStart;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getuVip() {
		return uVip;
	}

	public void setuVip(int uVip) {
		this.uVip = uVip;
	}

	public String getVipStart() {
		return vipStart;
	}

	public void setVipStart(String vipStart) {
		this.vipStart = vipStart;
	}

}

package com.oracle.entity;

public class Order {

	private int orderId;
	private int deskId;
	private int uId;
	private String uName;
	private double price;
	private int orderStatus;

	public Order() {

	}

	public Order(int orderId, int deskId, int uId, String uName, double price, int orderStatus) {
		super();
		this.orderId = orderId;
		this.deskId = deskId;
		this.uId = uId;
		this.uName = uName;
		this.price = price;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

}

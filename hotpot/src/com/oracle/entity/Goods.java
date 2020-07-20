package com.oracle.entity;

import com.oracle.daoImpl.GoodsDaoImp;

public class Goods {
	private int Id;
	private String Name;
	private double Price;
	private int Recommendation;
	
	public Goods() {
		super();
	}

	public Goods(int id, String name, double price, int recommendation) {
		super();
		Id = id;
		Name = name;
		Price = price;
		Recommendation = recommendation;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getRecommendation() {
		return Recommendation;
	}

	public void setRecommendation(int recommendation) {
		Recommendation = recommendation;
	}

	@Override
	public String toString() {
		return "Goods [Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Recommendation=" + Recommendation + "]";
	}

}

package com.oracle.entity;

public class Worker {
	private int workerId;
	private String workerName;
	private double workerPhoneNumber;
	private int year;
	private float workerSalary;

	public Worker() {
		super();
	}

	public Worker(int workerId, String workerName, double workerPhoneNumber, int year, float workerSalary) {
		super();
		this.workerId = workerId;
		this.workerName = workerName;
		this.workerPhoneNumber = workerPhoneNumber;
		this.year = year;
		this.workerSalary = workerSalary;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public double getWorkerPhoneNumber() {
		return workerPhoneNumber;
	}

	public void setWorkerPhoneNumber(double workerPhoneNumber) {
		this.workerPhoneNumber = workerPhoneNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getWorkerSalary() {
		return workerSalary;
	}

	public void setWorkerSalary(float workerSalary) {
		this.workerSalary = workerSalary;
	}

}

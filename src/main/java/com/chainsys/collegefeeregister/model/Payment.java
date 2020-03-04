package com.chainsys.collegefeeregister.model;

import java.sql.Date;

public class Payment {

	public static Payment getInstance() {
		return new Payment();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public int getFeeCourseId() {
		return feeCourseId;
	}

	public void setFeeCourseId(int feeCourseId) {
		this.feeCourseId = feeCourseId;
	}

	public int getSemId() {
		return semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private int id;
	private Date date;
	private String regno;
	private int feeCourseId;
	private int semId;
	private int amount;

	@Override
	public String toString() {
		return "PaymentDetail [id=" + id + ", date=" + date + ", regno=" + regno + ", feeCourseId=" + feeCourseId
				+ ", semId=" + semId + ", amount=" + amount + "]";
	}

}

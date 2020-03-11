package com.chainsys.collegefeeregister.model;

public class Semester {

	private int id;
	private int accYear;
	private String semType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getaccYear() {
		return accYear;
	}

	public void setaccYear(int accYear) {
		this.accYear = accYear;
	}

	public String getsemType() {
		return semType;
	}

	public void setsemType(String semType) {
		this.semType = semType;
	}

	@Override
	public String toString() {
		return "Semester [id=" + id + ", accYear=" + accYear + ", semType=" + semType + "]";
	}

}

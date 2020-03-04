package com.chainsys.collegefeeregister.model;

public class Student {

	public static Student getInstance() {
		return new Student();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public int getStud_active() {
		return stud_active;
	}

	public void setStud_active(int stud_active) {
		this.stud_active = stud_active;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourse_id(int courseId) {
		this.courseId = courseId;
	}

	private String name;
	private String regno;
	private int stud_active;
	private int courseId;
	private String mail;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Stud_Class [name=" + name + ", regno=" + regno + ", stud_active=" + stud_active + ", course ID="
				+ courseId + "]";
	}
}

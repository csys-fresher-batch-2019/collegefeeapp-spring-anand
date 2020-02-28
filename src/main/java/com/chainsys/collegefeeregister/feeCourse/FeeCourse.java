package com.chainsys.collegefeeregister.feeCourse;

public class FeeCourse {

	public static FeeCourse getInstance() {
		return new FeeCourse();
	}

	private int id;
	private int courseId;
	private int categoryId;
	private int amount;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}

package com.chainsys.collegefeeregister.model;

public class Course {

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int courseId;
	private int deptId;
	private int degreeId;
	private int status;

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", deptId=" + deptId + ", degreeId=" + degreeId + ", status=" + status
				+ "]";
	}

}

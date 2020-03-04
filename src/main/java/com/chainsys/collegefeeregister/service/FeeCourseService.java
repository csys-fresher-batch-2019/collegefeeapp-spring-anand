package com.chainsys.collegefeeregister.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.collegefeeregister.dao.FeeCourseDAO;

public class FeeCourseService {

	@Autowired
	FeeCourseDAO obj;

	public void addCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		obj.addCourseFee(courseId, feeCategoryId, amount);
	}

	public void updateCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		obj.updateCourseFee(courseId, feeCategoryId, amount);
	}

	public int getCourseFeeId(int courseId, int feeCategoryId) throws Exception {
		return obj.getCourseFeeId(courseId, feeCategoryId);
	}

}

package com.chainsys.collegefeeregister.service;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.FeeCourseDAO;
import com.chainsys.collegefeeregister.dao.impl.FeeCourseDAOImplementation;

@Service
public class FeeCourseService {

	FeeCourseDAO obj = new FeeCourseDAOImplementation();

	public void addCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		obj.addCourseFee(courseId, feeCategoryId, amount);
	}

	public void updateCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		obj.updateCourseFee(courseId, feeCategoryId, amount);
	}

	public int getCourseFeeId(int courseId, int feeCategoryId) throws Exception {
		return obj.getCourseFeeId(courseId, feeCategoryId);
	}

	public int getCourseFeeAmount(int feeCourseId) throws Exception {
		return obj.getCourseFeeAmount(feeCourseId);
	}
}

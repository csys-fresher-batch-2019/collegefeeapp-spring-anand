package com.chainsys.collegefeeregister.dao;

public interface FeeCourseDAO {
	
	void addCourseFee(int courseid,int feeCategoryId,int amount) throws Exception;
	
	void updateCourseFee(int courseId,int feeCategoryId,int amount) throws Exception;
	
	int getCourseFeeId(int courseId,int feeCategoryId) throws Exception;

}

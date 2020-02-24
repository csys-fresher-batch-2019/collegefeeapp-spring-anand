package com.chainsys.feeCourse;

public interface FeeCourseInterface {
	
	void addCourseFee(int courseid,int feeCategoryId,int amount) throws Exception;
	
	void updateCourseFee(int courseId,int feeCategoryId,int amount) throws Exception;
	
	int getCourseFeeId(int courseId,int feeCategoryId) throws Exception;

}

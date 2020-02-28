package com.chainsys.collegefeeregister.department;

import java.util.ArrayList;

public interface DeptInterface {

	void addDepartment(String name) throws Exception;
	int getDepartmentId(String departmentName) throws Exception;	
	String getDepartmentName(int deptId) throws Exception;
	ArrayList<String> listAllDepartments() throws Exception;

}

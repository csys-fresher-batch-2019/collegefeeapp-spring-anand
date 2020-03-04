package com.chainsys.collegefeeregister.dao;

import java.util.ArrayList;

public interface DepartmentDAO {

	void addDepartment(String name) throws Exception;
	int getDepartmentId(String departmentName) throws Exception;	
	String getDepartmentName(int deptId) throws Exception;
	ArrayList<String> listAllDepartments() throws Exception;

}

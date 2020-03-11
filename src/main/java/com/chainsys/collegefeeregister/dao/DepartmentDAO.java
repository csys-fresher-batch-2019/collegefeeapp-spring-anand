package com.chainsys.collegefeeregister.dao;

import java.util.List;

import com.chainsys.collegefeeregister.model.Department;

public interface DepartmentDAO {

	void addDepartment(String name) throws Exception;

	int getDepartmentId(String departmentName) throws Exception;

	String getDepartmentName(int deptId) throws Exception;

	List<Department> listAllDepartments() throws Exception;

}

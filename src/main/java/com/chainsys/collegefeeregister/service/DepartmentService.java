package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.collegefeeregister.dao.DepartmentDAO;

public class DepartmentService {

	@Autowired
	DepartmentDAO obj;

	public void addDepartment(String name) throws Exception {
		obj.addDepartment(name);
	}

	public int getDepartmentId(String departmentName) throws Exception {
		return obj.getDepartmentId(departmentName);
	}

	public String getDepartmentName(int deptId) throws Exception {
		return obj.getDepartmentName(deptId);
	}

	public ArrayList<String> listAllDepartments() throws Exception {
		return obj.listAllDepartments();
	}

}

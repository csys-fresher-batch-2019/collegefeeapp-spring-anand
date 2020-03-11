package com.chainsys.collegefeeregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.DepartmentDAO;
import com.chainsys.collegefeeregister.dao.impl.DeptDAOImplementation;
import com.chainsys.collegefeeregister.model.Department;

@Service
public class DepartmentService {

	DepartmentDAO obj = new DeptDAOImplementation();

	public void addDepartment(String name) throws Exception {
		obj.addDepartment(name);
	}

	public int getDepartmentId(String departmentName) throws Exception {
		return obj.getDepartmentId(departmentName);
	}

	public String getDepartmentName(int deptId) throws Exception {
		return obj.getDepartmentName(deptId);
	}

	public List<Department> listAllDepartments() throws Exception {
		return obj.listAllDepartments();
	}

}

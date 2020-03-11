package com.chainsys.collegefeeregister.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.model.Department;
import com.chainsys.collegefeeregister.service.DepartmentService;

@RestController
@RequestMapping("api")
public class DepartmentController {

	@Autowired
	DepartmentService obj;

	@PostMapping("/addDepartment")
	public void addDepartment(@RequestParam("deptname") String pname) {

		try {
			obj.addDepartment(pname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/GetAllDept")
	public ArrayList<Department> list() {
		ArrayList<Department> list = null;
		try {
			list = obj.listAllDepartments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
package com.chainsys.collegefeeregister.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.dao.CourseInterface;
import com.chainsys.collegefeeregister.dao.impl.CourseDAOImplementation;
import com.chainsys.collegefeeregister.model.Course;

@RestController
@RequestMapping("api")
public class CourseController {

	CourseInterface obj = new CourseDAOImplementation();

	@PostMapping("/addCourse")
	public void addCourse(@RequestParam("degId") int degId, @RequestParam("deptId") int deptId) {

		try {
			obj.addCourse(degId, deptId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/GetAllCourse")
	public ArrayList<Course> list() {

		try {
			return obj.getAllCourse();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

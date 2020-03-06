package com.chainsys.collegefeeregister.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.model.Course;
import com.chainsys.collegefeeregister.service.CourseService;

@RestController
@RequestMapping("api")
public class CourseController {

	@Autowired
	CourseService obj;

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
		ArrayList<Course> list = null;
		try {
			list = obj.getAllCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@GetMapping("/GetCourseName")
	public String getCourseName(int courseId) {
		String name = null;
		try {
			name = obj.getCourseName(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;

	}

}

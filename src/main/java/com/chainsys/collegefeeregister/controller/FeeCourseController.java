package com.chainsys.collegefeeregister.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.feeCourse.FeeCourseDAOImplementation;
import com.chainsys.collegefeeregister.feeCourse.FeeCourseInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FeeCourseController {
	FeeCourseInterface obj = FeeCourseDAOImplementation.getInstance();

}

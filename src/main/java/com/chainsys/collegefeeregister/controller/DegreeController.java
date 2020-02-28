package com.chainsys.collegefeeregister.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.dao.DegreeInterface;
import com.chainsys.collegefeeregister.dao.impl.DegreeDAOImplementation;

@RestController
@RequestMapping("api")
public class DegreeController {

	DegreeInterface obj = new DegreeDAOImplementation();

	@PostMapping("/addDegree")
	public void addDegree(@RequestParam("deg_name") String pname) {

		try {
			obj.addDegree(pname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/GetAllDegree")
	public ArrayList<String> list() {

		try {
			return obj.getAllDegree();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

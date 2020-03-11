package com.chainsys.collegefeeregister.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.model.Degree;
import com.chainsys.collegefeeregister.service.DegreeService;

@RestController
@RequestMapping("api")
public class DegreeController {

	@Autowired
	DegreeService obj;

	@PostMapping("/addDegree")
	public void addDegree(@RequestParam("deg_name") String pname) {
		try {
			obj.addDegree(pname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/GetAllDegree")
	public ArrayList<Degree> list() {
		ArrayList<Degree> list = null;
		try {
			list = obj.getAllDegree();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

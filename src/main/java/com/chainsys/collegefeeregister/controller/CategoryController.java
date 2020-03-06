package com.chainsys.collegefeeregister.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.model.Category;
import com.chainsys.collegefeeregister.service.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryController {

	@Autowired
	CategoryService obj;

	@GetMapping("/GetAllCategory")
	public ArrayList<Category> getAllCategory() {
		ArrayList<Category> catlist = null;
		try {
			catlist = obj.getAllCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catlist;
	}

	@PostMapping("/AddCategory")
	public void addFeeCategory(@RequestBody Category c) {

		try {
			obj.addFeeCategory(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

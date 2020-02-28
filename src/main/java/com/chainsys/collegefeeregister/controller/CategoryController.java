package com.chainsys.collegefeeregister.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.collegefeeregister.category.Category;
import com.chainsys.collegefeeregister.category.CategoryDAOImplementation;
import com.chainsys.collegefeeregister.category.CategoryInterface;

@RestController
@RequestMapping("api")

public class CategoryController {
	CategoryInterface obj = CategoryDAOImplementation.getInstance();

	@GetMapping("/GetAllCategory")
	public ArrayList<Category> getAllCategory() {

		return null;

	}

}

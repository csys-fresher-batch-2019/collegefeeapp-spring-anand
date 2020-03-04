package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.collegefeeregister.dao.CategoryDAO;
import com.chainsys.collegefeeregister.model.Category;

public class CategoryService {

	@Autowired
	CategoryDAO obj;

	public void addFeeCategory(Category c) throws Exception {
		obj.addFeeCategory(c);
	}

	public int getFeeCategoryId(Category c) throws Exception {
		return obj.getFeeCategoryId(c);
	}

	public String getFeeCategoryName(Category c) throws Exception {
		return obj.getFeeCategoryName(c);
	}

	public ArrayList<Category> getAllCategory() throws Exception {
		return obj.getAllCategory();
	}

}

package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.CategoryDAO;
import com.chainsys.collegefeeregister.dao.impl.CategoryDAOImplementation;
import com.chainsys.collegefeeregister.model.Category;

@Service
public class CategoryService {

	CategoryDAO obj = new CategoryDAOImplementation();

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

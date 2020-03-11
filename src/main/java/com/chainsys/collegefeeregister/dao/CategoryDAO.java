package com.chainsys.collegefeeregister.dao;

import java.util.List;

import com.chainsys.collegefeeregister.model.Category;

public interface CategoryDAO {

	void addFeeCategory(Category c) throws Exception;

	int getFeeCategoryId(Category c) throws Exception;

	String getFeeCategoryName(Category c) throws Exception;

	List<Category> getAllCategory() throws Exception;
}

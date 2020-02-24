package com.chainsys.category;

import java.util.ArrayList;

public interface CategoryInterface {

	void addFeeCategory(Category c) throws Exception;
	int getFeeCategoryId(Category c) throws Exception;
	String getFeeCategoryName(Category c) throws Exception;
	ArrayList<Category> getAllCategory() throws Exception;
}

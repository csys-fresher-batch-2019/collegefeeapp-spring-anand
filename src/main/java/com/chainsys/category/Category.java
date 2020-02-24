package com.chainsys.category;

public class Category {

	public static Category getInstance() {
		return new Category();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String name;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}

package com.chainsys.collegefeeregister.degree;

import java.util.ArrayList;

public interface DegreeInterface {

	void addDegree(String name) throws Exception;

	int getDegreeId(String degreeName) throws Exception;

	String getDegreeName(int degreeId) throws Exception;

	ArrayList<String> getAllDegree() throws Exception;
}

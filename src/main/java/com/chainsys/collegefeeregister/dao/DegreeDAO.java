package com.chainsys.collegefeeregister.dao;

import java.util.ArrayList;

public interface DegreeDAO {

	void addDegree(String name) throws Exception;

	int getDegreeId(String degreeName) throws Exception;

	String getDegreeName(int degreeId) throws Exception;

	ArrayList<String> getAllDegree() throws Exception;
}

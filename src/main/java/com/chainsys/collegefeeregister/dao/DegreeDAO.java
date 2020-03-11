package com.chainsys.collegefeeregister.dao;

import java.util.ArrayList;

import com.chainsys.collegefeeregister.model.Degree;

public interface DegreeDAO {

	void addDegree(String name) throws Exception;

	int getDegreeId(String degreeName) throws Exception;

	String getDegreeName(int degreeId) throws Exception;

	ArrayList<Degree> getAllDegree() throws Exception;
}

package com.chainsys.collegefeeregister.dao;

import java.util.List;

import com.chainsys.collegefeeregister.model.Degree;

public interface DegreeDAO {

	void addDegree(String name) throws Exception;

	int getDegreeId(String degreeName) throws Exception;

	String getDegreeName(int degreeId) throws Exception;

	List<Degree> getAllDegree() throws Exception;
}

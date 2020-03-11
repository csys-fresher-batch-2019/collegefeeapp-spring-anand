package com.chainsys.collegefeeregister.dao;

import java.util.List;

import com.chainsys.collegefeeregister.model.Semester;

public interface SemesterDAO {

	void addSemester(Semester s) throws Exception;

	int getSemId(Semester s) throws Exception;

	String getSemester(Semester s) throws Exception;

	List<Semester> getAllSemester() throws Exception;
}

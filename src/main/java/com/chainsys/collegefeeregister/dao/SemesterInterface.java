package com.chainsys.collegefeeregister.dao;

import java.util.ArrayList;

import com.chainsys.collegefeeregister.model.Semester;

public interface SemesterInterface {

	void addSemester(Semester s) throws Exception;

	int getSemId(Semester s) throws Exception;

	String getSemester(Semester s) throws Exception;

	ArrayList<Semester> getAllSemester() throws Exception;
}

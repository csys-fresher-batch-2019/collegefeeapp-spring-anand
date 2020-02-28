package com.chainsys.collegefeeregister.semester;

import java.util.ArrayList;

public interface SemesterInterface {

	void addSemester(Semester s) throws Exception;

	int getSemId(Semester s) throws Exception;

	String getSemester(Semester s) throws Exception;

	ArrayList<Semester> getAllSemester() throws Exception;
}

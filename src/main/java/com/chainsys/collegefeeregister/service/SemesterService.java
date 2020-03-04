package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.SemesterDAO;
import com.chainsys.collegefeeregister.model.Semester;

@Service
public class SemesterService {

	@Autowired
	SemesterDAO obj;

	void addSemester(Semester s) throws Exception {
		obj.addSemester(s);
	}

	int getSemId(Semester s) throws Exception {
		return obj.getSemId(s);
	}

	String getSemester(Semester s) throws Exception {
		return obj.getSemester(s);
	}

	ArrayList<Semester> getAllSemester() throws Exception {
		return obj.getAllSemester();
	}

}

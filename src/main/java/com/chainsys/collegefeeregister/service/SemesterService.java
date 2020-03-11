package com.chainsys.collegefeeregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.SemesterDAO;
import com.chainsys.collegefeeregister.dao.impl.SemesterDAOImplementation;
import com.chainsys.collegefeeregister.model.Semester;

@Service
public class SemesterService {

	SemesterDAO obj = new SemesterDAOImplementation();

	public void addSemester(Semester s) throws Exception {
		obj.addSemester(s);
	}

	public int getSemId(Semester s) throws Exception {
		return obj.getSemId(s);
	}

	public String getSemester(Semester s) throws Exception {
		return obj.getSemester(s);
	}

	public List<Semester> getAllSemester() throws Exception {
		return obj.getAllSemester();
	}

}

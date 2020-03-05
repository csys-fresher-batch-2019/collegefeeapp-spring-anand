package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.DegreeDAO;
import com.chainsys.collegefeeregister.dao.impl.DegreeDAOImplementation;

@Service
public class DegreeService {

	DegreeDAO obj = new DegreeDAOImplementation();

	public void addDegree(String Name) throws Exception {
		obj.addDegree(Name);
	}

	public String getDegreeName(int degreeId) throws Exception {
		return obj.getDegreeName(degreeId);
	}

	public int getDegreeId(String degreeName) throws Exception {
		return obj.getDegreeId(degreeName);
	}

	public ArrayList<String> getAllDegree() throws Exception {
		return obj.getAllDegree();
	}

}

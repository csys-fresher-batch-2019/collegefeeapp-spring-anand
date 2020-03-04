package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.collegefeeregister.dao.DegreeDAO;

public class DegreeService {

	@Autowired
	DegreeDAO obj;

	public void addDegree(String Name) throws Exception {
		obj.addDegree(Name);
	}

	public String getDegreeName(int degreeId) throws Exception {
		return obj.getDegreeName(degreeId);
	}

	public int getDegreeId(String degreeName) throws Exception {
		return obj.getDegreeId(degreeName);
	}

	public ArrayList<String> list() throws Exception {
		return obj.getAllDegree();
	}

}

package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.DepartmentDAO;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Department;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class DeptDAOImplementation implements DepartmentDAO {

	public static DeptDAOImplementation getInstance() {
		return new DeptDAOImplementation();
	}

	public void addDepartment(String name) throws Exception {
		String sql = "insert into department(dept_id,dept_name) values( department_seq.nextval ,?)";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();
			logger.info(sql);
			stmt.setString(1, name);
			int rows = stmt.executeUpdate();
			logger.info("NO OF ROWS AFFECTED:" + rows);

		}
	}

	public int getDepartmentId(String departmentName) throws Exception {
		String sql1 = "select dept_id from department where dept_name=?";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1);) {
			Logger logger = Logger.getInstance();

			int deptId = 0;
			logger.info(sql1);
			stmt.setString(1, departmentName);
			try (ResultSet rs1 = stmt.executeQuery();) {
				if (rs1.next()) {
					deptId = rs1.getInt("dept_id");
				}
			} catch (Exception e) {
				throw new NotFoundException("Department does not Exist");
			}
			return deptId;
		}
	}

	public String getDepartmentName(int deptId) throws Exception {
		String sql = "select dept_name from department where dept_id=?";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();
			String deptName = "";

			logger.info(sql);
			stmt.setInt(1, deptId);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					deptName = rs.getString("dept_name");
				}
			} catch (Exception e) {
				throw new NotFoundException("Department Doesnot exist");
			}
			return deptName;
		}
	}

	public ArrayList<String> listAllDepartments() throws Exception {

		String sql = "select * from department order by dept_name";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			ArrayList<String> list = new ArrayList<>();

			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					String name = rs.getString("dept_name");

					Department d = new Department();
					d.setDeptName(name);

					list.add(d.getDeptName());
				}
			}
			return list;
		}
	}

}

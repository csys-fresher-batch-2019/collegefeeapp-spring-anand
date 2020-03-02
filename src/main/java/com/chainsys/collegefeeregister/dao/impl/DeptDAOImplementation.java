package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.DeptInterface;
import com.chainsys.collegefeeregister.model.Department;
import com.chainsys.collegefeeregister.sxcException.NotFoundException;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class DeptDAOImplementation implements DeptInterface {

	public static DeptDAOImplementation getInstance() {
		return new DeptDAOImplementation();
	}

	public void addDepartment(String name) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();
			String sql = "insert into department(dept_id,dept_name) values( department_seq.nextval ,'"
					+ name.toUpperCase() + "')";
			logger.info(sql);
			int rows = stmt.executeUpdate(sql);
			logger.info("NO OF ROWS AFFECTED:" + rows);

		}
	}

	public int getDepartmentId(String departmentName) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			int deptId = 0;
			String sql1 = "select dept_id from department where dept_name='" + departmentName + "'";
			logger.info(sql1);
			try (ResultSet rs1 = stmt.executeQuery(sql1);) {
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
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();
			String deptName = "";
			String sql = "select dept_name from department where dept_id=" + deptId + "";
			logger.info(sql);

			try (ResultSet rs = stmt.executeQuery(sql);) {
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
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			ArrayList<String> list = new ArrayList<>();

			String sql = "select * from department order by dept_name";
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					String name = rs.getString("dept_name");

					Department d = Department.getInstance();
					d.setDeptName(name);

					list.add(d.getDeptName());
				}
			}
			return list;
		}
	}

}

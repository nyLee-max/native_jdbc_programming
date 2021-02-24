package native_jdbc_programing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import native_jdbc_programing.dao.EmployeeDao;
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.util.JdbcUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl instance = new EmployeeDaoImpl();

	   public static EmployeeDaoImpl getInstance() {
	      if (instance == null) {
	         instance = new EmployeeDaoImpl();
	      }
	      return instance;
	   }

	   public EmployeeDaoImpl() {
	   }


	@Override
	public List<Employee> selectEmployeeByAll() {
	      String sql = "select empno,empname,title_no,title_name,manager_no,manager_name,salary,deptNo,deptName,floor from vw_full_employee ";
	      try (Connection con = JdbcUtil.getConnection();
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery()) {
	         if (rs.next()) {
	            List<Employee> list = new ArrayList<>();
	            do {
	               list.add(getEmployee(rs));
	            } while (rs.next());
	            return list;
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
	    int empno = rs.getInt("empno");
	      String empname = rs.getString("empname");
	      Title title = new Title(rs.getInt("title_no"));

		
		   try {
	            title.settName(rs.getString("title_name"));
	         } catch (SQLException e) {}
	      
	      Employee manager = new Employee(rs.getInt("manager_no"));
	      
	         try {
	            manager.setEmpName(rs.getString("manager_name"));
	         } catch (SQLException e) {}
	      
	      int salary = rs.getInt("salary");
	      Department dept = new Department(rs.getInt("deptNo"));
	      
	         try {
	            dept.setDeptName(rs.getString("deptName"));
	            dept.setFloor(rs.getInt("floor"));
	         } catch (SQLException e) {}
	      
	      return new Employee(empno, empname, title, manager, salary, dept);
	   }

	

	
	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		  String sql = "select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo from employee where empno =?";
	      try (Connection con = JdbcUtil.getConnection(); 
	            PreparedStatement pstmt = con.prepareStatement(sql)) {
	         pstmt.setInt(1, employee.getEmpNo());
	         try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	               return getEmployee(rs);
	            }

	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
	
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int Employee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
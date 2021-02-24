package native_jdbc_programing.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.impl.EmployeeDaoImpl;
import native_jdbc_programing.dto.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
private static EmployeeDao dao  = EmployeeDaoImpl.getInstance();



	@Test
	public void testSelectEmployeeByAll() {
		  System.out.printf("%s()%n", "testSelectEmployeeByAll");
	      List<Employee> employeeList = dao.selectEmployeeByAll();
	      Assert.assertNotNull(employeeList);
	      for (Employee e : employeeList) {
	         System.out.println(e);
	      }

	}

	@Test
	public void testSelectEmployeeByNo() {
	      System.out.printf("%s()%n", "testSelectEmployeeByNo");
	      Employee selEmp = new Employee(2106);
	      Employee emp = dao.selectEmployeeByNo(selEmp);
	      Assert.assertNotNull(emp);
	      System.out.println(emp);

	}

	@Test
	public void testInsertEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

}

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
import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Employee;
import native_jdbc_programing.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();

	@Test
	public void test01SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> employeeList = dao.selectEmployeeByAll();
		Assert.assertNotNull(employeeList);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
		// for (Employee e : employeeList) {
		// System.out.println(e);
		// }

	}

	@Test
	public void test02SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee selEmp = new Employee(2106);
		Employee emp = dao.selectEmployeeByNo(selEmp);
		Assert.assertNotNull(emp);
		System.out.println(emp);

	}

	@Test
	public void test03InsertEmployee() {
	System.out.printf("%s()%n", "testInsertEmployee");
	Employee newEmp = new Employee(1004, "천사", new Title(5), new Employee(4377), 2000000, new Department(1));
	int res = dao.insertEmployee(newEmp);
	Assert.assertEquals(1, res);
	System.out.println(dao.selectEmployeeByNo(newEmp));
	}

	@Test
	public void test04UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee newEmp = new Employee(1004, "천사2", new Title(4), new Employee(1003),2000000, new Department(2));
		int res = dao.updateEmployee(newEmp);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmp));
		
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee");
		Employee newEmp = new Employee(1004);
		int res = dao.deleteEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

}

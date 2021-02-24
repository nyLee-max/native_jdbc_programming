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

import native_jdbc_programing.dao.impl.DepartmentDaoImpl;
import native_jdbc_programing.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();
	

	@Test
	public void test04SelectDepartmentByAll() {
		System.out.printf("%s()%n", "testSelectDepartmentByAll");
		List<Department> departmentList = dao.selectDepartmentByAll();
		Assert.assertNotNull(departmentList);
		for(Department d : departmentList) {
			System.out.println(d);
		}
	}

	@Test
	public void test05SelectDepartmentByNo() {
		System.out.printf("%s()%n", "testSelectDepartmentByNo");
		Department department = new Department(3);
		Department searchDepartment = dao.selectDepartmentByNo(department);
		Assert.assertNotNull(searchDepartment);
		System.out.println(searchDepartment);
	}

	@Test
	public void test01InsertDepartment() {
		System.out.printf("%s()%n", "testInsertDepartment");
		Department newDepartment = new Department(5, "인사", 15);
		int res = dao.insertDepartment(newDepartment);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateDepartment() {
			System.out.printf("%s()%n", "testUpdateDepartment");
			Department newDepartment = new Department(5, "연구", 10);
			int res = dao.updateDepartment(newDepartment);
			Assert.assertEquals(1, res);
			System.out.println(dao.selectDepartmentByNo(newDepartment));
	}

	@Test
	public void test03DeleteDepartment() {
		System.out.println("%s()%n, testDeleteDepartment");
		int res = dao.deleteDepartment(5);
		Assert.assertEquals(1, res);
	}

}

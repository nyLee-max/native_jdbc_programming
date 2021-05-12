package native_jdbc_programing.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import native_jdbc_programing.dao.impl.TitleDaoImpl;
import native_jdbc_programing.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoimplTest {
	private static TitleDao dao = TitleDaoImpl.getInstance();
	
	

	@Test
	public void test04SelectTitleByAll() {
		System.out.printf("%s()%n", "testSelectTitleByAll");
		List<Title> titleList = dao.selectTitleByAll();
		Assert.assertNotNull(titleList);
		for(Title t : titleList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectTitleByNo() {
		System.out.printf("%s()%n", "testSelectTitleByNo");
		Title title = new Title(5);		
		Title searchTitle = dao.selectTitleByNo(title);
		Assert.assertNotNull(searchTitle);
		System.out.println(searchTitle);
	}

	@Test
	public void test01InsertTitle() {
		System.out.printf("%s()%n", "testInsertTitle");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateTitle() {
			System.out.printf("%s()%n", "testUpdateTitle");
			Title newTitle = new Title(6, "계약직");
			int res = dao.updateTitle(newTitle);
			Assert.assertEquals(1, res);
			System.out.println(dao.selectTitleByNo(newTitle));
		}
	
	@Test
	public void test03DeleteTitle() {
		System.out.printf("%s()%n", "testDeleteTitle");
		int res = dao.deleteTitle(6);
		Assert.assertEquals(1, res);
	}

}

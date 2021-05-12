package native_jdbc_programing.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import native_jdbc_programing.dto.Department;
import native_jdbc_programing.dto.Title;
import native_jdbc_programing.util.JdbcUtil;

public class TransactionService {
	public String transAddTitleAndDepartment(Title title, Department dept) {
		String titlesql = "insert into title values(?,?)";
		String deptsql = "insert into department values (?, ?, ?)";

		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;
		String res = null;

		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);

			tPstmt = con.prepareStatement(titlesql);
			tPstmt.setInt(1, title.gettNo());
			tPstmt.setString(2, title.gettName());
			tPstmt.executeUpdate();

			dPstmt = con.prepareStatement(deptsql);
			dPstmt.setInt(1, dept.getDeptno());
			dPstmt.setString(2, dept.getDeptName());
			dPstmt.setInt(3, dept.getFloor());
			dPstmt.executeUpdate();

			con.commit();
			res = "commit";
			
		} catch (SQLException e) {
			res = "rollback";
			rollbackUtil(con);
		} finally {
			System.out.println(res);
			closeUtil(con, tPstmt, dPstmt);
		}

		return res;

	}

	private void closeUtil(Connection con, PreparedStatement tPstmt, PreparedStatement dPstmt) {
		try {
			con.setAutoCommit(true);
			if (tPstmt != null)
				tPstmt.close();
			if (tPstmt != null)
				tPstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void rollbackUtil(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public int transRemoveTitleAndDepartment(Title title, Department dept) {
		String titlesql = "delete from title where tno = ?";
		String deptsql = "delete from department where deptno = ?";

		Connection con = null;
		PreparedStatement tPstmt = null;
		PreparedStatement dPstmt = null;

		int res = 0;

		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			System.out.println("res > " + res);
			
		    tPstmt = con.prepareStatement(titlesql);
			tPstmt.setInt(1, title.gettNo());
			res += tPstmt.executeUpdate();
			
			System.out.println("res >" + res);

			dPstmt = con.prepareStatement(deptsql);
			dPstmt.setInt(1, dept.getDeptno());
			res += dPstmt.executeUpdate();
			
			System.out.println("res >" + res);

			if (res == 2) {
				con.commit();
				System.out.println("commit()");
			} else {
				throw new SQLException();
			}

		} catch (SQLException e) {
			rollbackUtil(con);
		} finally {
			closeUtil(con, tPstmt, dPstmt);

		}
		return res;
	}
}

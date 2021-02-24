package native_jdbc_programing.dto;

public class Department {
	private int deptno;
	private String deptName;
	private int floor;
	
	public Department() {
	
	}
	
	public Department(int deptno) {
		this.deptno = deptno;
		
	}
	
	public Department(int deptno, String deptName, int floor) {
		this.deptno = deptno;
		this.deptName = deptName;
		this.floor = floor;
	}
	public final int getDeptno() {
		return deptno;
	}
	public final void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public final String getDeptName() {
		return deptName;
	}
	public final void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public final int getFloor() {
		return floor;
	}
	public final void setFloor(int floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return String.format("Department [deptno=%s, deptName=%s, floor=%s]", deptno, deptName, floor);
	}
	
	
}

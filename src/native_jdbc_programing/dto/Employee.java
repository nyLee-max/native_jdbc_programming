package native_jdbc_programing.dto;

public class Employee {
	private int empNo;
	private String empName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;

	public Employee(int empNo) {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
	}

	public final int getEmpNo() {
		return empNo;
	}

	public final void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public final String getEmpName() {
		return empName;
	}

	public final void setEmpName(String empName) {
		this.empName = empName;
	}

	public final Title getTitle() {
		return title;
	}

	public final void setTitle(Title title) {
		this.title = title;
	}

	public final Employee getManager() {
		return manager;
	}

	public final void setManager(Employee manager) {
		this.manager = manager;
	}

	public final int getSalary() {
		return salary;
	}

	public final void setSalary(int salary) {
		this.salary = salary;
	}

	public final Department getDept() {
		return dept;
	}

	public final void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return String.format("Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s]", empNo,
				empName, title, manager, salary, dept);
	}

}

select user(), database();

show tables;

desc title;
desc department;
desc employee;

select tno,tname from title;
select tno, tname from title where tno = 3;

delete from title where tno = 6;
update title set tname = '계약직' where tno = 6;
delete from title where tno = 6;
insert into title values(6, "인턴");
delete from department where deptNo = 5;
	
select deptNo,deptName,floor from department;
select empno,empname,title,manager,salary,dept from employee;

select deptno, deptname,floor from department;

select deptNo,deptName,floor from department;

select deptNo,deptName,floor from department where deptno = 1;

update department set deptName = "대리" where deptNo = 3;
select user(), database();

select  * from employee;

create or replace view vw_full_employee
as
select e.empno
		,e.empname
		,t.tno as title_no
		,t.tname as title_name
		,e.manager as manager_no
		,m.empname as manager_name
		,e.salary
		,d.deptNo
		,d.deptName
		,floor
	from employee e join title t on e.title = t.tno 
		left join employee m on e.manager = m.empno
		join department d on e.dept = d.deptNo;

	select empno,empname,title_no,title_name,manager_no,manager_name,salary,deptNo,deptName,floor from vw_full_employee;
	
select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo
	from employee;
	
insert into employee values(1004, '천사', 5, 4377, 2000000, 1);
update employee 
	set dept = 3
	where empno = 1004;
delete
	from employee 
	where empno = 1004;
	
select * from employee;
drop table department;
drop table title;
drop table employee;
select * from department;

desc employee;
package com.cg.hr.daos;

import java.util.List;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;

public interface EmpDao {

	List<Employee> getEmpList() throws EmpException;
	Employee getEmpOnId(int empNo) throws EmpException;
	void insertNewEmp(Employee emp) throws EmpException;
	void updateName(int empNo, String empNm) throws EmpException;
	List<Integer> getEmpNoList() throws EmpException;
}

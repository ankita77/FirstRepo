package com.cg.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;

@Repository
public class EmpDaoImpl implements EmpDao {

	@PersistenceContext
	private EntityManager manager;
	@Override
	public List<Employee> getEmpList() throws EmpException {
	
		String strQry = "SELECT e FROM Employee e";  //ATTRIBUTE OF CLASS
		TypedQuery<Employee> qry = manager.createQuery(strQry, Employee.class);
		List<Employee> empList = qry.getResultList();
		
		return empList;
	}
	@Override
	public Employee getEmpOnId(int empNo) throws EmpException {
		
		return manager.find(Employee.class, empNo);
	}
	
	
	@Override
	public void insertNewEmp(Employee emp) throws EmpException {
		manager.persist(emp);
		
	}
	
	public List<Integer> getEmpNoList() throws EmpException {
		
		String strQry = "SELECT e.empNo FROM Employee e";  //ATTRIBUTE OF CLASS
		TypedQuery<Integer> qry = manager.createQuery(strQry, Integer.class);
		List<Integer> empNoList = qry.getResultList();
		
		return empNoList;
	}
	@Override
	public void updateName(int empNo, String empNm) throws EmpException {
		Employee emp = manager.find(Employee.class, empNo);
		emp.setEmpNm(empNm);
	}

}

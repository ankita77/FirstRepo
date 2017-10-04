package com.cg.hr.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hr.daos.EmpDao;
import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Resource
	private EmpDao dao;
	@Override
	public List<Employee> getEmpList() throws EmpException {
		// TODO Auto-generated method stub
		return dao.getEmpList();
	}
	
	
	@Override
	public Employee getEmpOnId(int empNo) throws EmpException {
		// TODO Auto-generated method stub
		return dao.getEmpOnId(empNo);
	}
	
	
	@Override
	public void insertNewEmp(Employee emp) throws EmpException {
		dao.insertNewEmp(emp);
		
	}


	@Override
	public void updateName(int empNo, String empNm) throws EmpException {
		dao.updateName(empNo, empNm);
		
	}


	
	public List<Integer> getEmpNoList() throws EmpException {
		// TODO Auto-generated method stub
		return dao.getEmpNoList();
	}

}

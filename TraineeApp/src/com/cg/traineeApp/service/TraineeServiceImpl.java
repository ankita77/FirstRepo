package com.cg.traineeApp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.traineeApp.daos.TraineeDao;
import com.cg.traineeApp.entities.Trainee;
import com.cg.traineeApp.exception.TraineeException;


@Service
@Transactional
public class TraineeServiceImpl implements TraineeService {

	
	@Resource
	private TraineeDao dao;
	@Override
	public void insertNewTrainee(Trainee trainee) throws TraineeException {
		dao.insertNewTrainee(trainee);

	}
	
	
	
	@Override
	public Trainee getTraineeOnId(int id) throws TraineeException {
		return dao.getTraineeOnId(id);
	}
	
	
	
	@Override
	public List<Trainee> getTraineeList() throws TraineeException {
		return dao.getTraineeList();
	}



	@Override
	public void deleteTrainee(int id) throws TraineeException {
		dao.deleteTrainee(id);
		
	}



	@Override
	public void updateTrainee(int id, String name, String domain, String loc) {
		dao.updateTrainee(id, name, domain, loc);
		
	}

}

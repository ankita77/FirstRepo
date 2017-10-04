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
public class TraineeService implements ITraineeService {

	@Resource
	private TraineeDao dao;
	@Override
	public List<Trainee> getTraineeList() throws TraineeException {
		// TODO Auto-generated method stub
		return dao.getTraineeList();
	}

	@Override
	public Trainee getTraineeOnId(int traineeId) throws TraineeException {
		// TODO Auto-generated method stub
		return dao.getTraineeOnId(traineeId);
	}

	@Override
	public void insertNewTrainee(Trainee trainee) throws TraineeException {
		// TODO Auto-generated method stub
		dao.insertNewTrainee(trainee);
	}

}

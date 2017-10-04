package com.cg.traineeApp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.traineeApp.entities.Trainee;
import com.cg.traineeApp.exception.TraineeException;

@Repository
public class TraineeDao implements ITraineeDao {

	
	@PersistenceContext
	private EntityManager manager;
	@Override
	public List<Trainee> getTraineeList() throws TraineeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainee getTraineeOnId(int traineeId) throws TraineeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewTrainee(Trainee trainee) throws TraineeException {
		manager.persist(trainee);
		
	}

}

package com.cg.traineeApp.service;

import java.util.List;

import com.cg.traineeApp.entities.Trainee;
import com.cg.traineeApp.exception.TraineeException;

public interface ITraineeService {
	List<Trainee> getTraineeList() throws TraineeException;
	Trainee getTraineeOnId(int traineeId) throws TraineeException;
	void insertNewTrainee(Trainee trainee) throws TraineeException;
}

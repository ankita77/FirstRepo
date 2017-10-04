package com.cg.traineeApp.service;

import java.util.List;

import com.cg.traineeApp.entities.Trainee;
import com.cg.traineeApp.exception.TraineeException;



public interface TraineeService {

	void insertNewTrainee(Trainee trainee) throws TraineeException;
	Trainee getTraineeOnId(int id) throws TraineeException;
	List<Trainee> getTraineeList() throws TraineeException;
	void deleteTrainee(int id) throws TraineeException;
	void updateTrainee(int id, String name, String domain, String loc);
}

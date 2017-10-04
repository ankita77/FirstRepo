package com.cg.traineeApp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.traineeApp.entities.Trainee;
import com.cg.traineeApp.exception.TraineeException;


@Repository
public class TraineeDaoImpl implements TraineeDao {

	
	@PersistenceContext
	private EntityManager manager;
	@Override
	public void insertNewTrainee(Trainee trainee) throws TraineeException {
		manager.persist(trainee);

	}
	
	
	@Override
	public Trainee getTraineeOnId(int id) throws TraineeException {
		return manager.find(Trainee.class, id);
	}
	
	
	@Override
	public List<Trainee> getTraineeList() throws TraineeException {
	
		String strQry = "SELECT e FROM Trainee e";  //ATTRIBUTE OF CLASS
		TypedQuery<Trainee> qry = manager.createQuery(strQry, Trainee.class);
		List<Trainee> TraineeList = qry.getResultList();
		
		return TraineeList;
	}


	@Override
	public void deleteTrainee(int id) throws TraineeException {
		Trainee trainee = manager.find(Trainee.class, id);
	    manager.remove(trainee);
		
	}


	@Override
	public void updateTrainee(int id, String name, String domain, String loc) {
		Trainee trainee = manager.find(Trainee.class, id);
	    trainee.setTraineeName(name);
	    trainee.setTraineeDomain(domain);
	    trainee.setTraineeLoc(loc);
		
	}

}

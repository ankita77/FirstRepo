package com.cg.traineeApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Trainee")
public class Trainee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineeLocation;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	
	@Column(name="trainee_name")
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
	
	@Column(name="trainee_domain")
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	
	
	@Column(name="trainee_location")
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	
	
	public Trainee() {
		super();
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLocation=" + traineeLocation + "]";
	}
	
	
	
	
	
	
}

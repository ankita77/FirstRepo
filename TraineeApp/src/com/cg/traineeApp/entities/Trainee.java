package com.cg.traineeApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAINEE")
public class Trainee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineeLoc;
	
	
	
	@Id
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	
	
	
	@Column(name="TRAINEE_NAME")
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
	
	
	@Column(name="TRAINEE_DOMAIN")
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	
	
	
	
	@Column(name="LOCATION")
	public String getTraineeLoc() {
		return traineeLoc;
	}
	public void setTraineeLoc(String traineeLoc) {
		this.traineeLoc = traineeLoc;
	}
	
	
	
	
	public Trainee() {
		super();
	}
	
	
	
	
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLoc=" + traineeLoc + "]";
	}
	

	
	
	
	

}

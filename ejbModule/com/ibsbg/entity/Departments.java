package com.ibsbg.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotBlank;

import com.ibsbg.base.Constants;

@Entity
@NamedQuery(name="Departments.findAll", query="SELECT d FROM Departments d")
			  
public class Departments implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int depId;
	
	@NotBlank(message=Constants.DEPARTMENT_NAME_NOT_NULL_MESSAGE)
	private String depName;
	
	@NotBlank(message=Constants.DEPARTMENT_LOCATION_NOT_NULL_MESSAGE)
	private String location;
	
	public Departments(){
		super();
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	//@Override
	//public String toString() {
	//	return this.depName;
	//}
}

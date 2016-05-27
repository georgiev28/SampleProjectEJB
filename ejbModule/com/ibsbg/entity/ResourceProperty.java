package com.ibsbg.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQueries({@NamedQuery(name="findAllProperties", query="select p from ResourceProperty p"),
			   @NamedQuery(name="findPropertiesByResource", query="select p from ResourceProperty p where p.resource = :resource")})
public class ResourceProperty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int resPropId;
	
	@NotBlank(message="This filed can`t be empty")
	private String resourcePropName;
	@NotBlank(message="This filed can`t be empty")
	private String resourcePropValue;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Resource resource;
	
	public ResourceProperty() {
		super();
	}

	public int getResPropId() {
		return resPropId;
	}

	public void setResPropId(int resPropId) {
		this.resPropId = resPropId;
	}

	public String getResourcePropName() {
		return resourcePropName;
	}

	public void setResourcePropName(String resourcePropName) {
		this.resourcePropName = resourcePropName;
	}

	public String getResourcePropValue() {
		return resourcePropValue;
	}

	public void setResourcePropValue(String resourcePropValue) {
		this.resourcePropValue = resourcePropValue;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}

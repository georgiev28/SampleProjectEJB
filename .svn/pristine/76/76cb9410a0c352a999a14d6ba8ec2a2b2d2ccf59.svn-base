package com.ibsbg.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity(name="role")
@NamedQuery(name="findAllRoles", query="select r from role r")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	
	private String name;
	private boolean isRoleAdmin;
	
	public Role() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean isRoleAdmin() {
		return isRoleAdmin;
	}

	public void setRoleAdmin(boolean isRoleAdmin) {
		this.isRoleAdmin = isRoleAdmin;
	}
	
}

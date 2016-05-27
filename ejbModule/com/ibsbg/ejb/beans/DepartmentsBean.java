package com.ibsbg.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.ibsbg.entity.Address;
import com.ibsbg.entity.Departments;

@Stateless
@LocalBean
public class DepartmentsBean {
	
	@PersistenceContext
	private EntityManager em;
	
	public DepartmentsBean() {
	}
	
	public Departments createDepartment(Departments dep){
		em.persist(dep);
		return dep;
	}
	
	public Departments updateDepartments(Departments dep){
		em.merge(dep);
		return dep;
	}
	
	public void removeDepartment(int depid){
		em.remove(getDepartment(depid));
	}
	
	public Departments getDepartment(int depid){
		return em.find(Departments.class, depid);
	}
	
	public List<Departments> showAllDepartments(){
		return em.createNamedQuery("Departments.findAll",Departments.class).getResultList();
	}
}

package com.ibsbg.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ibsbg.entity.Role;

@Stateless
@LocalBean
public class RoleDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public RoleDAO() {
	}
	
	public Role addRole(Role role){
		em.persist(role);
		return role;
	}
	
	public Role updateRole(Role role){
		em.merge(role);
		return role;
	}
	
	public void removeRole(int roleid){
		em.remove(getRole(roleid));
	}
	
	public Role getRole(int roleid){
		return em.find(Role.class, roleid);
	}
	
	public List<Role> getAllRoles(){
		return em.createNamedQuery("findAllRoles", Role.class).getResultList();
	}
}

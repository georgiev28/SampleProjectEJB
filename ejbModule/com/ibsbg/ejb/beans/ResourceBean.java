package com.ibsbg.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ibsbg.entity.Resource;

@Stateless
@LocalBean
public class ResourceBean {

	@PersistenceContext
	private EntityManager em;
	
	public ResourceBean() {}
	
	public Resource create(Resource resource){
		em.persist(resource);
		return resource;
	}
	
	public Resource update(Resource resource){
		em.merge(resource);
		return resource;
	}
	
	public void remove(int resourceId){
		em.remove(findResource(resourceId));
	}
	
	public Resource findResource(int resourceId){
		Resource res = em.find(Resource.class, resourceId);
		return res;
	}
	
	public List<Resource> findAllResources(){
		return em.createNamedQuery("findAllResources", Resource.class).getResultList();
	}
}

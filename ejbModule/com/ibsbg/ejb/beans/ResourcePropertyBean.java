package com.ibsbg.ejb.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ibsbg.entity.Resource;
import com.ibsbg.entity.ResourceProperty;

import java.util.List;

import javax.ejb.LocalBean;

@LocalBean
@Stateless
public class ResourcePropertyBean {

	@PersistenceContext
	private EntityManager em;
	
	public ResourceProperty create(ResourceProperty rp){
		em.persist(rp);
		return rp;
	}
	
	public ResourceProperty update(ResourceProperty rp){
		em.merge(rp);
		return rp;
	}
	
	public void remove(int propId){
		em.remove(findProperty(propId));
	}
	
	public ResourceProperty findProperty(int propId){
		return em.find(ResourceProperty.class, propId);
	}
	
	public List<ResourceProperty> findAllProperties(){
		return em.createNamedQuery("findAllProperties", ResourceProperty.class).getResultList();
	}
	
	public List<ResourceProperty> findAllPropertiesByResource(Resource resource){
		return em.createNamedQuery("findPropertiesByResource",ResourceProperty.class).setParameter("resource", resource).getResultList();
	}
}

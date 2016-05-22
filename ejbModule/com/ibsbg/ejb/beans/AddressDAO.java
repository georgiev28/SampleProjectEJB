package com.ibsbg.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ibsbg.entity.Address;

@Stateless
@LocalBean
public class AddressDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public AddressDAO(){
	}
	
	public Address create(Address address){
		em.persist(address);
		return address;
	}
	
	public Address update(Address address){
		em.merge(address);
		return address;
	}
	
	public void remove(int addressid){
		em.remove(getAddress(addressid));
	}
	
	public Address getAddress(int addressid){
		return em.find(Address.class, addressid);
	}
	
	public List<Address> printAllAddresses(){
		return em.createNamedQuery("Address.getAll",Address.class).getResultList();
	}
}

package com.ibsbg.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ibsbg.entity.Departments;
import com.ibsbg.entity.User;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
    public UserDAO() {
    }

    public User create(User user){
    	em.persist(user);
    	return user;
    }
    
    public User update(User user){
    	em.merge(user);
    	return user;
    }
    
    public void remove(int userid){
    	em.remove(findUser(userid));
    }
    
    public User findUser(int userid){
    	User u = em.find(User.class, userid);
    	return u;
    }
    
    public List<User> printAllUsers(){
    	return em.createNamedQuery("findAllUsers",User.class).getResultList();
    }
    
    public List<User> printAllUsersByDepartment(Departments department){
    	return em.createNamedQuery("findUserByDepartment",User.class).setParameter("department", department).getResultList();
    }
    
    public List<User> printAllUsersByCity(String city){
    	return em.createNamedQuery("findUserByAddress", User.class).setParameter("city", city).getResultList();
    }
    
    public User findUserByUserName(String uName){
    	User user = new User();
    	
    	TypedQuery<User> res = em.createNamedQuery("findUserByUserName",User.class);
    	res.setParameter("userName", uName);
    	
    	try {
		  user = res.getSingleResult();
		  return user;
		} 
    	catch (NoResultException e) {
		}
    	return null;
    }
    //method for finding registered users
    public User findRegisteredUser(String password, String uName){
    	User result = new User();
		TypedQuery<User> reg = em.createNamedQuery("findRegisteredUser", User.class);
		reg.setParameter("userName", uName);
		reg.setParameter("password", password);
		
		try {
			result = reg.getSingleResult();
			return result;
		} 
		catch (NoResultException e) {
			// TODO: handle exception
		}
		
		return null;
	}
    
    public boolean validate(String userName, String password){
		
    	try {
    		if (!findRegisteredUser(password, userName).equals(null)) {
    			return true;
    		}
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		return false;
	}
}

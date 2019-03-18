package com.cts.grizzly.dao;

import java.util.List;   

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Profile;
 

@Repository("profileDAO")
@Transactional
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	//@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public Profile getUserStatus(String userName) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = null;
		String query = "from Profile where userId=?";
		org.hibernate.query.Query<Profile> query2 = null;
		
		
		
		try {
			session = sessionFactory.getCurrentSession();
			System.out.println("in dao");
			System.out.println(userName);
			query2 = session.createQuery(query);
			query2.setParameter(0,userName);
			Profile profile = query2.getSingleResult();
			System.out.println("retrieved");
			
			
			if(profile==null){
				System.out.println("condition failed");
				return null;
			}
			else
			{
				System.out.println("condition passed");

			
			return profile;} 
			
	}finally {
	}
	
		
		
	
	
	
	}

	}

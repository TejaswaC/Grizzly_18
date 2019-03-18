package com.cts.grizzly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Category;




@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	//@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Transactional
	public List<Category> getAllCategories() {
		Session session = null;
		String query = "from Category";
		org.hibernate.query.Query<Category> query2=null;
System.out.println("in dao");
		// TODO Auto-generated method stub
		
			session = sessionFactory.getCurrentSession();
			query2=session.createQuery(query);
List<Category> list = query2.getResultList();

System.out.println("Inside DAO -getAllCat");

		System.out.println("All Categories Retrieved");
return list;
		}
		
	
		
	
		
		
	}
	
	//@Transactional(readonly="true")
	
	

	/*public Login authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = null;
		String query = "from login_table where userName=? and password=?";
		org.hibernate.query.Query<Login> query2 = null;
		try {
			session = sessionFactory.getCurrentSession();
			query2 = session.createQuery(query);
			query2.getParameter(userName);
			query2.getParameter(password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(session!=null){
				session.close();
			}
		}
		return null;
	}*/



package com.cts.grizzly.dao;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;




@Repository("productDAO")
@Transactional(propagation=Propagation.SUPPORTS)
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	//@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Transactional
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = null;
		// TODO Auto-generated method stub
		
			session = sessionFactory.getCurrentSession();
		
		System.out.println("Inside DAO");

		session.save(product);
		System.out.println("Tupple inserted");
			return "Inserted";
		
		
			
			
		
	}
	
	
	@Transactional
	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		Session session = null;

		String query = "from Product";
		org.hibernate.query.Query<Product> query2=null;
		System.out.println("in product dao");
		// TODO Auto-generated method stub
		
			session = sessionFactory.getCurrentSession();
			query2=session.createQuery(query);
			List<Product> list = query2.getResultList();

			System.out.println("Inside DAO -getAllProducts");

		System.out.println("All Products Retrieved");
		return list;
	}


	@Transactional
	public String deleteProductByID(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		//String query = "from Empl WHERE empID=?";
		//org.hibernate.query.Query<Employee> query2=null;

		// TODO Auto-generated method stub
		
			session = sessionFactory.getCurrentSession();
			Product product = session.load(Product.class, id);
			session.delete(product);
			//query2=session.createQuery(query);
			//query2.setParameter(0, Id);
			//List<Employee> list = query2.getResultList();

			System.out.println("Inside DAO -deleteProdByID");
			
			return "Product Deleted";

	}
	
	@Transactional(readOnly=true)
	public Product getProductByID(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		String query = "from Product WHERE Id=?";
		org.hibernate.query.Query<Product> query2=null;

		// TODO Auto-generated method stub
		
			session = sessionFactory.getCurrentSession();
			query2=session.createQuery(query);
			query2.setParameter(0, id);
			Product product = query2.getSingleResult();

			System.out.println("Inside DAO -getProdByID");

			System.out.println("Specific Product Retrieved");
			return product;
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



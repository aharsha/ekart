package com.harsha.ecommerce.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.ecommerce.model.User;

@Component
public class UserDaoImpl {

	@Autowired
	SessionFactory sessionFactory;
	
	public void testSessionFactory()
	{
		System.out.println("sf-----------------"+sessionFactory);
	}
	
	public  void insertUser(User user)
	{
		Session  session= sessionFactory.openSession();
		
		session.save(user);
	Transaction transaction=	session.beginTransaction();
	
	transaction.commit();
	session.close();
	}
	
	public boolean checkUser(User  user)
	{
		
		Session  session= sessionFactory.openSession();
		Query query=session.createQuery("from User  where email=:em and password=:pwd ");
	query.setParameter("em",user.getEmail());
	query.setParameter("pwd",user.getPassword());
	
		Object object=query.uniqueResult();
	User  user2=(User)object;
	if(user2!=null)
	{
		return true;
	}
	else
	{
		return false;
	}
	}
	
}


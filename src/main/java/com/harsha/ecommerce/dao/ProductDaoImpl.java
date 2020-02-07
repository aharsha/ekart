package com.harsha.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.ecommerce.model.Product;
import com.harsha.ecommerce.model.User;

@Component
public class ProductDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	
void   insertProduct(Product product)
	{
		Session session= sessionFactory.openSession();
	session.save(product);
	Transaction  transaction=session.beginTransaction();
	
	transaction.commit();
	session.close();
	
	}


List getAllProducts()
{
	Session session= sessionFactory.openSession();
	Query query=session.createQuery("from Product");
	List  productList=query.list();
	session.close();
return productList;


}

public Product getProduct(int proId)
{
	Session session= sessionFactory.openSession();
	Query query=session.createQuery("from Product where productId=:id");
	query.setParameter("id",proId);
	Product  product=(Product)query.uniqueResult();
	return product;
}

}

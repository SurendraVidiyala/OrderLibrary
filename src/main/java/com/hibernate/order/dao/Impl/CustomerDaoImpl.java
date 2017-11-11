package com.hibernate.order.dao.Impl;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.order.dao.CustomerDao;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {
	public Customer saveCustomer(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
		return customer;

	}

	public Customer findCustomerFullData(Long custId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = session.get(Customer.class, custId);
		customer.getPaymentMethod().size();
		session.close();
		return customer;
	}

	public void deleteCustomer(Long custId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query myquery = session.createQuery("delete from Customer where id=:customerId");
		myquery.setParameter("customerId", custId);
		myquery.executeUpdate();
		session.close();
	}

	public Customer updateCustomer(Customer customer) {
		return null;
	}

	public Customer findCustomerAddressData(Long custId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = session.get(Customer.class, custId);
		session.close();
		return customer;
	}

	public Customer getCustomer(Long custId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer customer = session.get(Customer.class, custId);
		return customer;
	}

	public Customer findCustomer(Customer customer) {
		return null;
	}

}

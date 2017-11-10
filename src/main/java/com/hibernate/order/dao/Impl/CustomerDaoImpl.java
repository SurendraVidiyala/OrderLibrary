package com.hibernate.order.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.order.dao.CustomerDao;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {
    public int insertCustomer(Customer customer) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        int customId = customer.getCustomerId();
        System.out.println("Customer ID is: " + customId);
        return customId;
    }


    public void deleteCustomer(Customer customer) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Customer custom = (Customer) session.load(Customer.class, customer.getCustomerId());
        session.delete(custom);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted Customer ID: " + custom.getCustomerId());
    }
}

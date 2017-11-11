package com.hibernate.order.dao.Impl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.order.dao.AddressDao;
import com.hibernate.order.entity.Address;
import com.hibernate.order.util.HibernateUtil;

public class AddressDaoImpl implements AddressDao {

	@Override
	public Address updateAddress(Address address) {
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(address);
		session.getTransaction().commit();
		System.out.println("Address ID is: " + address.getCutomerId());
		return address;
	}

	@Override
	public Long deleteAddress(Long customId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query myquery = session.createQuery("delete from Customer where id=:customerId");
		myquery.setParameter("customerId", customId);
		myquery.executeUpdate();
		session.close();
		return customId;

	}
}

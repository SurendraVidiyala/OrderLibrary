package com.hibernate.order.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.order.dao.PaymentMethodDao;
import com.hibernate.order.entity.PaymentMethod;
import com.hibernate.order.util.HibernateUtil;

public class PaymentMethodDaoImpl implements PaymentMethodDao {

	public void insert(PaymentMethod paymentMethod) {
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(paymentMethod);
		session.getTransaction().commit();
		session.close();
		System.out.println("PaymentMethod ID is: " + paymentMethod.getPaymentId());
		factory.close();
	}

	@Override
	public List<PaymentMethod> get(int customerId) {
		return null;
	}

	@Override
	public void update(PaymentMethod paymentMethod) {

	}

	@Override
	public void delete(int paymentId) {

	}

}

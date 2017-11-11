package com.hibernate.order.dao.Impl;

import java.util.List;

import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	public List<PaymentMethod> findPaymentMethods(Long customId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query myquery = session.createQuery("from PaymentMethod as pm WHERE pm.customer.customerId = :id");
        List<PaymentMethod> list = myquery.getResultList();
        session.close();
        return list;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public void deletePaymentMethods(Long customId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "delete FROM PaymentMethod AS pm WHERE pm.customer.customerId = :id";
		int i = session.createQuery(query).setLong("id", customId).executeUpdate();
		session.getTransaction().commit();
	    session.close();
	}

	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(paymentMethod);
		session.getTransaction().commit();
		session.close();
		System.out.println("Payment Updated successfully!");
		return paymentMethod;
	}

	public void insertPaymentMethods(List<PaymentMethod> methods) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			for (PaymentMethod paymentMethod : methods) {
				session.save(paymentMethod);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}

	public PaymentMethod getPaymentMethod(Integer paymentMethodId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PaymentMethod pm = session.get(PaymentMethod.class, paymentMethodId);
		session.close();
		return pm;
	}

}



package com.hibernate.order.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.order.dao.AddressDao;
import com.hibernate.order.entity.Address;
import com.hibernate.order.util.HibernateUtil;

public class AddressDaoImpl implements AddressDao{

    public void insertAddress(Address addresses) {
        SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(addresses);
        session.getTransaction().commit();
        System.out.println("Address ID is: " + addresses.getAddressId());
    }
}

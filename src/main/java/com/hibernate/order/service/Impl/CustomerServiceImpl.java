package com.hibernate.order.service.Impl;

import com.hibernate.order.dao.CustomerDao;
import com.hibernate.order.dao.PaymentMethodDao;
import com.hibernate.order.dao.Impl.CustomerDaoImpl;
import com.hibernate.order.dao.Impl.PaymentMethodDaoImpl;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.entity.PaymentMethod;
import com.hibernate.order.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public int addCustomerDetails(Customer customer) {
		 CustomerDao customerDao = new CustomerDaoImpl();
	        return customerDao.insertCustomer(customer);
	}

	@Override
	public void addPayments(int customerId, PaymentMethod paymentMethod) {
		PaymentMethodDao paymentMethodDao = new PaymentMethodDaoImpl();
        paymentMethodDao.insert(paymentMethod);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		 CustomerDao dao = new CustomerDaoImpl();
	        dao.deleteCustomer(customer);
	}

}

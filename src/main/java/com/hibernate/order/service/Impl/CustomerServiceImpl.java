package com.hibernate.order.service.Impl;

import java.util.List;

import com.hibernate.order.dao.CustomerDao;
import com.hibernate.order.dao.PaymentMethodDao;
import com.hibernate.order.dao.Impl.CustomerDaoImpl;
import com.hibernate.order.dao.Impl.PaymentMethodDaoImpl;
import com.hibernate.order.entity.Address;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.entity.PaymentMethod;
import com.hibernate.order.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerDao customerDao = new CustomerDaoImpl();
	private static PaymentMethodDao paymentMethodDao = new PaymentMethodDaoImpl();

	public void deleteCustomer(Long customId) {
		customerDao.deleteCustomer(customId);
	}

	public void deletePaymentMethods(Long customId) {
		paymentMethodDao.deletePaymentMethods(customId);
	}

	public Customer createCustomer(Customer customer) {
		Customer insertedCustomer = customerDao.saveCustomer(customer);
		return insertedCustomer;
	}

	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		return paymentMethodDao.updatePaymentMethod(paymentMethod);
	}

	public Customer findCustomerFullData(Long custId) {
		return customerDao.findCustomerFullData(custId);
	}

	public void createPaymentMethods(List<PaymentMethod> methods) {
		paymentMethodDao.insertPaymentMethods(methods);

	}

	public Customer findCustomerAddressData(Long custId) {
		return customerDao.findCustomerAddressData(custId);
	}

	public PaymentMethod getPaymentMethod(Integer paymentMethodId) {
		return paymentMethodDao.getPaymentMethod(paymentMethodId);
	}

	public List<PaymentMethod> findPaymentMethods(Long custId) {
		return paymentMethodDao.findPaymentMethods(custId);
	}

	public Customer getCustomer(Long custId) {
		return customerDao.getCustomer(custId);
	}

	public void updateAddress(Address address) {

	}

	public void updateCustomer(Customer customer) {

	}

}
package com.hibernate.order.service;

import java.util.List;

import com.hibernate.order.entity.Address;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.entity.PaymentMethod;

public interface CustomerService {
	
	void updateAddress(Address address);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long customId);

	void deletePaymentMethods(Long customId);

	Customer createCustomer(Customer customer);

	PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);

	Customer findCustomerFullData(Long customId);

	void createPaymentMethods(List<PaymentMethod> methods);

	Customer findCustomerAddressData(Long customId);
	
	PaymentMethod getPaymentMethod(Integer paymentMethodId);
	
	List<PaymentMethod> findPaymentMethods(Long customId);
	
	Customer getCustomer(Long custId);


}

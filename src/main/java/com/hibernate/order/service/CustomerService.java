package com.hibernate.order.service;

import com.hibernate.order.entity.Customer;
import com.hibernate.order.entity.PaymentMethod;

public interface CustomerService {
	
	int addCustomerDetails(Customer customer);

    void addPayments(int customerId, PaymentMethod paymentMethod);

    void deleteCustomer(Customer customer);


}

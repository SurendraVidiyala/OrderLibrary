package com.hibernate.order.dao;

import com.hibernate.order.entity.Customer;

public interface CustomerDao {

	Customer saveCustomer(Customer customer);

	Customer findCustomer(Customer customer); 

	Customer findCustomerFullData(Long customId);

    void deleteCustomer(Long customId);

	Customer updateCustomer(Customer customer);

	Customer findCustomerAddressData(Long customId);

	Customer getCustomer(Long customId);
}

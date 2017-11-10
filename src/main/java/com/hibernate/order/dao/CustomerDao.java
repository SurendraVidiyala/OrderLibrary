package com.hibernate.order.dao;

import com.hibernate.order.entity.Customer;

public interface CustomerDao {

    int insertCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}

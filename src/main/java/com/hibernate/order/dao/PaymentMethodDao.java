package com.hibernate.order.dao;

import java.util.List;

import com.hibernate.order.entity.PaymentMethod;

public interface PaymentMethodDao {

    void insert(PaymentMethod paymentMethod);

    List<PaymentMethod> get(int customerId);

    void update(PaymentMethod paymentMethod);

    void delete(int paymentId);
}

package com.hibernate.order.dao;

import java.util.List;

import com.hibernate.order.entity.PaymentMethod;

public interface PaymentMethodDao {

	List<PaymentMethod> findPaymentMethods(Long customId);

	void deletePaymentMethods(Long customId);

	PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);

	void insertPaymentMethods(List<PaymentMethod> methods);

	PaymentMethod getPaymentMethod(Integer paymentMethodId);
}

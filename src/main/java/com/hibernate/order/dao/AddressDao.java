package com.hibernate.order.dao;

import com.hibernate.order.entity.Address;

public interface AddressDao {

	Address updateAddress(Address address);

	Long deleteAddress(Long customId);
}

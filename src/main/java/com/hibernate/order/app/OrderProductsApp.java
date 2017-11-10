package com.hibernate.order.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hibernate.order.entity.Address;
import com.hibernate.order.entity.CardType;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.entity.PaymentMethod;
import com.hibernate.order.service.CustomerService;
import com.hibernate.order.service.Impl.CustomerServiceImpl;

public class OrderProductsApp {
	
	
	 private static Customer setCustomerDetails() throws ParseException {

	        Customer customer = new Customer();
	        customer.setCustomerName("Suren");

	        Address address = new Address();
	        address.setAptNo(134);
	        address.setStreetNo(3001);
	        address.setStreetName("Martin L King Blvd");
	        address.setCity("Chicago");
	        address.setState("IL");
	        address.setZipCode(76001);
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
	        Date date = sdf.parse("09/11/2017");
	        customer.setDateOfBirth(date);
	        customer.setAnnualSalary(5500);
	        customer.setAddresses(address);
	        address.setCustomer(customer);

	        PaymentMethod paymentMethod = new PaymentMethod();
	        paymentMethod.setCardName("Citi");
	        paymentMethod.setCardNo("4536-9876-2301");
	        paymentMethod.setCardType(CardType.MASTERCARD);
	        paymentMethod.setDateFrom(new Date());

	        PaymentMethod paymentMethod1 = new PaymentMethod();
	        paymentMethod1.setCardName("Bofa");
	        paymentMethod1.setCardNo("5736-9876-2112");
	        paymentMethod1.setCardType(CardType.VISA);
	        paymentMethod1.setDateFrom(new Date());

	        List<PaymentMethod> list = new ArrayList<PaymentMethod>();
	        list.add(paymentMethod);
	        list.add(paymentMethod1);
	        customer.setPaymentMethod(list);

	        return customer;
	    }

	public static void main(String[] args) throws ParseException {

		  CustomerService service = new CustomerServiceImpl();
	        Customer customer = setCustomerDetails();

	        Scanner scan = new Scanner(System.in);
	        int input;
	        System.out.println("1. Add Customer along with Address");
	        System.out.println("2. Delete Customer and all associated information");
			System.out.println("3. Add PaymentMethods for a customer");
			System.out.println("Enter your choice:");
	        boolean loop = true;
	        while(loop) {
	            input = scan.nextInt();

	            switch (input) {
	                case 1:
	                    service.addCustomerDetails(customer);
	                    System.out.println("The customerId is: " + customer.getCustomerId());
	                    break;

	                case 2:
	                    service.deleteCustomer(customer);
	                    break;

	                default:
	                    System.out.println("Please Enter valid Choice!");
	                    break;
	            }
	        }
	        
	        scan.close();
	    }
	}

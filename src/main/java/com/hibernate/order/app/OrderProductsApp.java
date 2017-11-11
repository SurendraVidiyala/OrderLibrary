package com.hibernate.order.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hibernate.order.entity.Address;
import com.hibernate.order.entity.CardType;
import com.hibernate.order.entity.Customer;
import com.hibernate.order.entity.PaymentMethod;
import com.hibernate.order.service.CustomerService;
import com.hibernate.order.service.Impl.CustomerServiceImpl;

public class OrderProductsApp {

	public static Scanner s = new Scanner(System.in);
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	private static CustomerService customerService = new CustomerServiceImpl();
	public static String cardType;

	private static Customer setCustomerDetails() throws ParseException {
		Customer customer = new Customer();
		System.out.println("Enter customer name: ");
		customer.setCustomerName(s.next());
		System.out.println("Enter date of birth (YYYY/MM/DD): ");
		customer.setDateOfBirth(sdf.parse(s.next()));
		System.out.println("Enter annual salary: ");
		customer.setAnnualSalary(s.nextFloat());
		System.out.println("Enter Address: ");
		Address address = new Address();
		System.out.println("street: ");
		address.setStreetName(s.next());
		System.out.println("city: ");
		address.setCity(s.next());
		System.out.println("state: ");
		address.setState(s.next());
		System.out.println("country");
		address.setCity(s.next());
		System.out.println("zipcode: ");
		address.setZipCode(s.next());
		customer.setAddresses(address);
		address.setCustomer(customer);
		return customer;

	}

	private static List<PaymentMethod> setCustomerPaymentMethods(Customer customer) throws ParseException {
		System.out.println("Enter payment method details");
		System.out.println("Enter number of payments methods you want to add: ");
		int noOfPaymentMethods = s.nextInt();
		PaymentMethod pm = null;
		List<PaymentMethod> methods = new ArrayList<PaymentMethod>();

		for (int i = 0; i < noOfPaymentMethods; i++) {
			pm = new PaymentMethod();
			System.out.println("Enter card name: ");
			pm.setCardName(s.next());
			System.out.println("Enter card number: ");
			pm.setCardNo(s.next());
			System.out.println("Enter card type ");
			cardType = s.nextLine();
			CardType ct = null;
			ct = CardType.valueOf(cardType.toUpperCase());
			pm.setCardType(ct);
			System.out.println("Enter date from (YYYY/MM/DD): ");
			pm.setDateFrom(sdf.parse(s.next()));
			pm.setCustomer(customer);
			methods.add(pm);

		}
		return methods;
	}

	public static void main(String[] args) throws ParseException {

		int choice;
		String ans = "";
		do {
			System.out.println("1. Add Customer along with Address");
			System.out.println("2. Add PaymentMethods for a customer");
			System.out.println("3. Fetch all the PaymentMethods for given customer");
			System.out.println("4. Fetch Customer along with Address and Payment methods");
			System.out.println("5. Fetch Customer along with Address but no Payment methods");
			System.out.println("6. Delete Customer and all associated information");
			System.out.println("7. Update customer payment methods with new information");
			System.out.println("8. Delete a Payment method of a customer");
			System.out.println("9. Apply logging for all the above api/methods");
			System.out.println("Enter your choice:");
			choice = s.nextInt();
			switch (choice) {
			case 1:
				Customer customer = setCustomerDetails();
				Customer insertedCustomer = customerService.createCustomer(customer);
				break;
			case 2:
				System.out.println("Enter the customer id");
				Customer customer1 = customerService.getCustomer(s.nextLong());
				if (customer1 != null) {
					List<PaymentMethod> methods = setCustomerPaymentMethods(customer1);
					customerService.createPaymentMethods(methods);

				} else
					System.out.println("Customer does not exist!");
				break;
			case 3:
				System.out.println("Enter customer id for which you want to display payment method details: ");
				List<PaymentMethod> methods1 = customerService.findPaymentMethods(s.nextLong());
				for (PaymentMethod pm : methods1)
					System.out.println(pm);
				break;

			case 4:
				System.out.println("Enter the customer id of the customer for which you want to display all the info");
				Customer customer3 = customerService.findCustomerFullData(s.nextLong());
				System.out.println(customer3);
				break;

			case 5:
				System.out.println(
						"Enter the customer id of the customer for which you want to display customer info and address");
				Customer customer4 = customerService.findCustomerAddressData(s.nextLong());
				System.out.println("Customer name: " + customer4.getCustomerName() + " Dob: "
						+ customer4.getDateOfBirth() + " Annual salary: " + customer4.getAnnualSalary());
				System.out.println("Customer address: " + customer4.getAddresses());
				break;

			case 6:
				System.out.println("Enter the customer id of the customer you want to delete");
				customerService.deleteCustomer(s.nextLong());
				break;

			case 7:
				Integer noOfPmMethods = 0;
				Long custId;
				Integer pmId;
				List<Integer> pmIds = new ArrayList<Integer>();
				System.out.println("Enter the customer id of the customer you want to update payment method");
				custId = s.nextLong();
				List<PaymentMethod> methods = customerService.findPaymentMethods(custId);
				Customer customer5 = customerService.getCustomer(custId);
				System.out.println("The following are the available payment methods for this customer");
				for (PaymentMethod pm : methods) {
					System.out.println(pm);
					pmIds.add(pm.getPaymentId());
				}
				System.out.println("How many payment methods do you want to update?");
				noOfPmMethods = s.nextInt();
				while (noOfPmMethods > methods.size()) {
					System.out.println("Enter correct no. of payment methods: ");
					noOfPmMethods = s.nextInt();
				}
				for (int i = 0; i < noOfPmMethods; i++) {
					System.out.println("Enter the details for payment method " + (i + 1));
					PaymentMethod pm = new PaymentMethod();
					System.out.println("Enter payment method id you want to update: ");
					pmId = s.nextInt();
					while (!pmIds.contains(pmId)) {
						System.out.println("Enter correct payment method id!");
						pmId = s.nextInt();
					}
					pm.setPaymentId(pmId);
					pm.setCustomer(customer5);
					System.out.println("Enter card no: ");
					pm.setCardNo(s.next());
					System.out.println("Enter card name: ");
					pm.setCardName(s.next());
					System.out.println("Enter date from: ");
					pm.setDateFrom(sdf.parse(s.next()));
					System.out.println("Enter card type: ");
					cardType = s.nextLine();
					CardType ct = null;
					ct = CardType.valueOf(cardType.toUpperCase());
					pm.setCardType(ct);
					PaymentMethod pm1 = customerService.updatePaymentMethod(pm);
					System.out.println("Updated payment method " + (i + 1));
					System.out.println(pm1);
				}
				break;

			case 8:
				System.out.println("Enter customer id for which you want to delete payment methods: ");
				customerService.deletePaymentMethods(s.nextLong());
				break;

			default:
				System.out.println("Enter correct choice");

			}
			System.out.println("Do u want to continue?(yes/no)");
			ans = s.next();
		} while (ans.equalsIgnoreCase("yes"));

	}

}
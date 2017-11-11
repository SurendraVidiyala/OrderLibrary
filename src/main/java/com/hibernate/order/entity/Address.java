package com.hibernate.order.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6888794749772533965L;

	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "customer"))
	private Long cutomerId;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Customer customer;

	private Integer aptNo, streetNo;

	private String zipCode;
	private String streetName, city, state;

	public Long getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(Long cutomerId) {
		this.cutomerId = cutomerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getAptNo() {
		return aptNo;
	}

	public void setAptNo(Integer aptNo) {
		this.aptNo = aptNo;
	}

	public Integer getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(Integer streetNo) {
		this.streetNo = streetNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String string) {
		this.zipCode = string;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Address [cutomerId=" + cutomerId + ", customer=" + customer + ", aptNo=" + aptNo + ", streetNo="
				+ streetNo + ", zipCode=" + zipCode + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + "]";
	}

}

package com.onlineshop.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName="id")
	private UserDetail userDetails;
	@Column(name="address_line_one")
	private String addressLineOne;
	@Column(name="address_line_two")
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	@Column(name="postal_code")
	private String postalCode;
	@Column(name="is_billing")
	private byte isBilling;
	@Column(name="is_shipping")
	private byte isShipping;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public UserDetail getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public byte getIsBilling() {
		return isBilling;
	}
	public void setIsBilling(byte isBilling) {
		this.isBilling = isBilling;
	}
	public byte getIsShipping() {
		return isShipping;
	}
	public void setIsShipping(byte isShipping) {
		this.isShipping = isShipping;
	}
	
	
}

package com.onlineshop.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String role;
	private byte enable;
	private String password;
	@Column(name="contact_number")
	private String contactNumber;
	private String email;

	@OneToMany(mappedBy="userDetails",fetch=FetchType.LAZY)
	private Set<Product> productList;
	
	@OneToMany(mappedBy="userDetails",fetch=FetchType.LAZY)
	private Set<Address> addressList;
	
	
	
	public Set<Product> getProductList() {
		return productList;
	}
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
	public Set<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public byte getEnable() {
		return enable;
	}
	public void setEnable(byte enable) {
		this.enable = enable;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", enable=" + enable + ", password=" + password + ", contactNumber=" + contactNumber + ", email="
				+ email + "]";
	}
	
}

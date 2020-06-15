package com.onlineshop.entity;


import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product {

	@Transient
	private MultipartFile file;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String code;
	
	@NotBlank(message="Product Name is Required")
	private String name;
	
	@NotBlank(message="Brand Name is Required")
	private String brand;
	
	@NotBlank(message="Description is Required")
	private String description;
	
	@Column(name="unit_price")
	@DecimalMin(value="1",inclusive=true,message="Price must be higher than 1")
	@NotNull(message="price is Required")
	private BigDecimal unitPrice;
	
	@Min(value=1,message="Quantity must be higher than 1")
	private long quantity;
	
	@Column(name="is_active")
	private byte isActive;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id",referencedColumnName="id")
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supplier_id",referencedColumnName="id")
	private UserDetail userDetails;
	
	
	private long purchases;
	private long views;

	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Product() {
		this.code="PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public UserDetail getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public byte getIsActive() {
		return isActive;
	}
	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public long getPurchases() {
		return purchases;
	}
	public void setPurchases(long purchases) {
		this.purchases = purchases;
	}
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", isActive=" + isActive
				+ ", category=" + category + ", userDetails=" + userDetails + ", purchases=" + purchases + ", views="
				+ views + "]";
	}

}

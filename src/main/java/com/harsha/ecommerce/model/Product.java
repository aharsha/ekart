package com.harsha.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product
{
/*
 Encapsulation :
 
 declareing fields(instance variable)  as private 
 defining methods as public to access private fields
 */
	@Id
	private int productId;
	@Column
	private String productName;
	@Column
	private int productPrice;
	@Transient
	private MultipartFile proImage;
	
	public MultipartFile getProImage() {
		return proImage;
	}
	public void setProImage(MultipartFile proImage) {
		this.proImage = proImage;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	}
	
	
	
	
	
	
	
	
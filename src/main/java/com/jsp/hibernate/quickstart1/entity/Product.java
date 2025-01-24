package com.jsp.hibernate.quickstart1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productbrand=" + productbrand
				+ ", productprice=" + productprice + "]";
	}
	@Id
	private int productid;
	private String productname;
	private String productbrand;
	private int productprice;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductbrand() {
		return productbrand;
	}
	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
}

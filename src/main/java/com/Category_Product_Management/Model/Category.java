package com.Category_Product_Management.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String name;
	
	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name="FK_CategoryId", referencedColumnName = "id")
	public List<Product> product;
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}


	public Category(long id, String name, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", product=" + product + "]";
	}
	
	
	
}

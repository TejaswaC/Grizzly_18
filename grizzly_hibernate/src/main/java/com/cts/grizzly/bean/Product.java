package com.cts.grizzly.bean;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Product")
@Table(name="product_table")
public class Product {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="category")

	private String category;
	@Column(name="name")

	private String name;
	@Column(name="description")

	private String description;
	@Column(name="price")

	private float price;
	@Column(name="brand")

	private String brand;
	@Column(name="rating")

	private String rating;
	@Column(name="offer")

	private String offer;
	
	@Column(name="blockStatus", columnDefinition="varchar(255) default 1")

	private String blockStatus;
	
	public String getBlockStatus() {
		return blockStatus;
	}

	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}

	public Product() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", brand=" + brand + ", rating=" + rating + ", offer=" + offer + ", blockStatus="
				+ blockStatus + "]";
	}

	public Product(String id, String category, String name, String description, float price, String brand,
			String rating, String offer, String blockStatus) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
		this.rating = rating;
		this.offer = offer;
		this.blockStatus = blockStatus;
	}

	
}
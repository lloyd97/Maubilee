package com.maubilee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="petcategory")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "petshop")
	private String petshop;
	
	@Column(name = "breed")
	private String breed;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "picture")
	private String picture;

	public Pet() {
		super();
	}

	public Pet(String name, String type, String petshop, String breed, String price, String description, String contact,
			String picture) {
		super();
		this.name = name;
		this.type = type;
		this.petshop = petshop;
		this.breed = breed;
		this.price = price;
		this.description = description;
		this.contact = contact;
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPetshop() {
		return petshop;
	}

	public void setPetshop(String petshop) {
		this.petshop = petshop;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}

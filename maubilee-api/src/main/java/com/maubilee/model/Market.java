package com.maubilee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Market")
public class Market {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "picture")
	private String picture;

	public Market() {
		super();
	}

	public Market(String name, String duration, String region, String item, String price, String description,
			String contact, String picture) {
		super();
		this.name = name;
		this.duration = duration;
		this.region = region;
		this.item = item;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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

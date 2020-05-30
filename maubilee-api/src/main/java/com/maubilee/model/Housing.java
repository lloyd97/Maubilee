package com.maubilee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Housing")
public class Housing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "surface")
	private String surface;
	
	@Column(name = "bedroom")
	private String bedroom;
	
	@Column(name = "bathroom")
	private String bathroom;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "picture")
	private String picture;

	public Housing() {
		super();
	}

	public Housing(String title, String surface, String bedroom, String bathroom, String region, String price,
			String description, String contact, String picture) {
		super();
		this.title = title;
		this.surface = surface;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.region = region;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getBedroom() {
		return bedroom;
	}

	public void setBedroom(String bedroom) {
		this.bedroom = bedroom;
	}

	public String getBathroom() {
		return bathroom;
	}

	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

package com.maubilee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="maubileebusiness")
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "city")
	private String city;
		
	@Column(name = "isactive")
	private String isactive;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "recovercode")
	private String recovercode;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "advertpicture")
	private String advertpicture;
	
	@Column(name = "advertdescription")
	private String advertdescription;
	
	@Column(name = "advertprice")
	private String advertprice;
	
	@Column(name = "advertenddate")
	private String advertenddate;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "packages")
	private String packages;
	
	public Business() {
		super();
	}

	public Business(String name, String email, String password, String region, String city, String isactive,
			String phone, String recovercode, String location, String photo, String advertpicture,
			String advertdescription, String advertprice, String advertenddate, String category, String packages) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.region = region;
		this.city = city;
		this.isactive = isactive;
		this.phone = phone;
		this.recovercode = recovercode;
		this.location = location;
		this.photo = photo;
		this.advertpicture = advertpicture;
		this.advertdescription = advertdescription;
		this.advertprice = advertprice;
		this.advertenddate = advertenddate;
		this.category = category;
		this.packages = packages;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecovercode() {
		return recovercode;
	}

	public void setRecovercode(String recovercode) {
		this.recovercode = recovercode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAdvertpicture() {
		return advertpicture;
	}

	public void setAdvertpicture(String advertpicture) {
		this.advertpicture = advertpicture;
	}

	public String getAdvertdescription() {
		return advertdescription;
	}

	public void setAdvertdescription(String advertdescription) {
		this.advertdescription = advertdescription;
	}

	public String getAdvertprice() {
		return advertprice;
	}

	public void setAdvertprice(String advertprice) {
		this.advertprice = advertprice;
	}

	public String getAdvertenddate() {
		return advertenddate;
	}

	public void setAdvertenddate(String advertenddate) {
		this.advertenddate = advertenddate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}
	
	
	
}

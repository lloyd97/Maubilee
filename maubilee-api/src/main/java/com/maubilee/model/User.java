package com.maubilee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="maubileeuser")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "dob")
	private String dob;
	
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
	
	@Column(name = "isdangerous")
	private String isdangerous;
	
	@Column(name = "preferences")
	private String preferences;
	
	public User() {
		super();
	}

	public User(String firstname, String lastname, String email, String password, String role, String region,
			String city, String dob, String isactive, String phone, String recovercode, String location, String photo,
			String isdangerous, String preferences) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.region = region;
		this.city = city;
		this.dob = dob;
		this.isactive = isactive;
		this.phone = phone;
		this.recovercode = recovercode;
		this.location = location;
		this.photo = photo;
		this.isdangerous = isdangerous;
		this.preferences = preferences;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getIsdangerous() {
		return isdangerous;
	}

	public void setIsdangerous(String isdangerous) {
		this.isdangerous = isdangerous;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	
	
	
}

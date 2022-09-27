package com.app.SimpleApplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//JPA Annotations
@Entity
@Table (name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "surname",nullable = false)
	private String surname;
	
	@Column(name = "gender",nullable = false)
	private String gender;
	
	@Column(name = "dob",nullable = false)
	private String dob;
	
	@OneToOne(cascade= CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "work_id", referencedColumnName = "id")
	private WorkAddress workAdd;
	
	@OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "home_id", referencedColumnName = "id")
	private HomeAddress homeAdd;
	
	public User() {
		
	}
	
	public User(long id, String name, String surname, String gender, String dob, WorkAddress workAdd, HomeAddress homeAdd) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.dob = dob;
		this.workAdd= workAdd;
		this.homeAdd = homeAdd;
	}
	
	public String getWorkAdd() {
		return workAdd.getWorkAdd();
	}

	public void setWorkAdd(WorkAddress workAdd) {
		this.workAdd = workAdd;
	}

	public String getHomeAdd() {
		return homeAdd.getHomeAdd();
	}

	public void setHomeAdd(HomeAddress homeAdd) {
		this.homeAdd = homeAdd;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
}

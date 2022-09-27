package com.app.SimpleApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "homeAdd")
public class HomeAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	String homeAdd;
		
	
	
	public HomeAddress() {
		super();
		
	}
	
	public HomeAddress(String homeAdd) {
		this.homeAdd = homeAdd;	
	}
	
	public HomeAddress(long id, String homeAdd) {
		super();
		this.id = id;
		this.homeAdd = homeAdd;	
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHomeAdd() {
		return homeAdd;
	}
	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}
	

}


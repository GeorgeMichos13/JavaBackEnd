package com.app.SimpleApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table (name = "workAdd")
public class WorkAddress{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	
	String workAdd;
	
	
	public WorkAddress() {
		super();
		
	}
	public WorkAddress(String workAdd) {
		this.workAdd=workAdd;	
	}
	
	//addres
	public WorkAddress(long id, String workAdd) {
		super();
		this.id = id;
		this.workAdd = workAdd;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWorkAdd() {
		return workAdd;
	}
	public void setWorkAdd(String workAdd) {
		this.workAdd = workAdd;
	}
	
}


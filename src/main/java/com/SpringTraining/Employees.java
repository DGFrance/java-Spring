package com.SpringTraining;

import org.springframework.stereotype.Component;

@Component
public class Employees {
	private String name, gender, id;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employees(String id ,String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	public Employees (){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	}


package com.SpringTraining;

import org.springframework.stereotype.Component;

@Component
public class Employees {
	private String name, gender;

	public Employees(String name, String gender) {
		super();
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


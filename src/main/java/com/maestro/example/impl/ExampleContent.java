package com.maestro.example.impl;

import com.maestro.example.ExampleObject;

public class ExampleContent extends ExampleObject {
	
	private int id;	
	
	private String name;
	private String location;
	
	
	public ExampleContent(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
		createdAt = System.currentTimeMillis();
		updatedAt = System.currentTimeMillis();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

}

package com.maestro.example.impl;

import com.maestro.example.ExampleObject;

public class ExampleUser extends ExampleObject {
	
	private int id;
	private String name;

	public ExampleUser(int id, String name) {
		this.id = id;
		this.name = name;
		createdAt = System.currentTimeMillis();
		updatedAt = System.currentTimeMillis();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}

package com.example.model.path;

import java.util.ArrayList;
import java.util.List;

// This model represents a palina (bus stop) in the database. Every palina has an id and a coordinate
public class Palina {
	
	public String getId() {
		return id;
	}

	public Coordinates getLocation() {
		return location;
	}

	private String id;
	private Coordinates location;
	
	public Palina(String id,Coordinates location) {
		this.id=id;
		this.location=location;
	}
		
}

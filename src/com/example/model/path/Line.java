package com.example.model.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// This class represent a line (like Metro A, Metro B, etc...)
// Every line has an id, a name and a list of stops
public class Line {
	private List<LineStop> stops;
	private String name;
	private int id;	
	
	public Line(int id,String name) {
		super();
		this.name = name;
		this.id = id;
		stops=new ArrayList<LineStop>();
	}
	public List<LineStop> getStops() {
		return stops;
	}
		
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	public void addStop(LineStop ls) {
		stops.add(ls);
		ls.setParent(this);
	}
	
	
}

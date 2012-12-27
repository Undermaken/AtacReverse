package com.example.model.path;

// This class represents a line stop. Every stop has an id a name, the reference to the line which belongs, and a coordinate (its location on the map).
public class LineStop {
	private String name;
	private int id;
	private Line parent;
	private Coordinates location;
	
		
	public LineStop(int id,String name,  Coordinates location) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
	}
	
	public Line getParent() {
		return parent;
	}
	public void setParent(Line parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public Coordinates getLocation() {
		return location;
	}
}

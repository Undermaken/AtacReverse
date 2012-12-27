package com.example.model.path;

import java.util.Date;


public class FootStep extends GenericStep {

	public FootStep(String desc,Date eta, Coordinates coordinates) {
		super(desc,eta);
		this.coordinates = coordinates;
	}
	
	private Coordinates coordinates;

	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}

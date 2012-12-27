package com.example.model.path;

import java.util.Date;



public class RailStep extends GenericStep {
	
	
	public RailStep(String desc,Date eta, LineStop stop) {
		super(desc,eta);
		this.stop = stop;
	}
	
	private LineStop stop;


	public LineStop getStop() {
		return stop;
	}
	public void setStop(LineStop stop) {
		this.stop = stop;
	}
}

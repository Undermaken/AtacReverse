package com.example.model.path;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Path {
	
	public static class Distance {
		private double foot;
		private double bustram;
		private double underground;
		private double urbanrailway;
		private double regionalrailways;		
		private double total;		
		
		public Distance(double foot, double bustram, double underground,
				double urbanrailway, double regionalrailways, double total) {
			super();
			this.foot = foot;
			this.bustram = bustram;
			this.underground = underground;
			this.urbanrailway = urbanrailway;
			this.regionalrailways = regionalrailways;
			this.total = total;
		}	
		
		public Distance() {
			
		}
		
		public double getFoot() {
			return foot;
		}
		public void setFoot(double foot) {
			this.foot = foot;
		}
		public double getBustram() {
			return bustram;
		}
		public void setBustram(double bustram) {
			this.bustram = bustram;
		}

		public double getUnderground() {
			return underground;
		}
		public void setUnderground(double underground) {
			this.underground = underground;
		}
		public double getUrbanrailway() {
			return urbanrailway;
		}
		public void setUrbanrailway(double urbanrailway) {
			this.urbanrailway = urbanrailway;
		}
		public double getRegionalrailways() {
			return regionalrailways;
		}
		public void setRegionalrailways(double regionalrailways) {
			this.regionalrailways = regionalrailways;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}

		
	}
		
	private List<GenericPathStep<?>> mSteps;

	private Date mStart;
	private Date mEta;
	private Distance mDistances;
	private String mDestination;
	
	public Path(String destination,Distance distances,Date start,Date eta,GenericPathStep<?> ... steps) {
		mSteps = new ArrayList<GenericPathStep<?>>();
		int i;
		for (i=0;i<steps.length;i++) {			
			mSteps.add(steps[i]);
			if (i>0)
				steps[i-1].setNextStep(steps[i]);
		}			
		mStart=start;
		mEta=eta;
		mDistances=distances;
		mDestination = destination;
	}
	
	public Path(String destination) {
		mDestination = destination;
	}
	
	public List<GenericPathStep<?>> getSteps() {
		return mSteps;
	}

	public Date getStart() {
		return mStart;
	}

	public Date getEta() {
		return mEta;
	}

	public Distance getDistances() {
		return mDistances;
	}	
	
	public String getDestination() {
		return mDestination;
	}
	
}


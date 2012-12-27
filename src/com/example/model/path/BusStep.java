package com.example.model.path;

import java.util.Date;

public class BusStep extends GenericStep {
	public BusStep(String desc,Date eta, int palina) {
		super(desc,eta);
		this.palina = palina;
	}
	
	private int palina;

	public int getPalina() {
		return palina;
	}
	public void setPalina(int palina) {
		this.palina = palina;
	}
}

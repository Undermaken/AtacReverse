package com.example.model.path;



import android.graphics.Color;

public class FootPath extends GenericPathStep<FootStep> {
	
	FootPath() {
		super();
	}

	public FootPath(FootStep ... steps) {
		super(steps);
	}
	
	@Override
	public int getColor() {
		return Color.BLUE;
	}

}
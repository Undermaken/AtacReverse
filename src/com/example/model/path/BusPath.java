package com.example.model.path;



import android.graphics.Color;

public class BusPath extends GenericPathStep<BusStep> {
	
	private Line m_Line;
	
	public BusPath(Line line) {
		super();
		m_Line = line;
	}

	public BusPath(Line line,BusStep ... steps) {
		super(steps);
		m_Line = line;
	}
	
	public Line getLine() {
		return m_Line;
	}

	@Override
	public int getColor() {
		return Color.RED;
	}
	
}

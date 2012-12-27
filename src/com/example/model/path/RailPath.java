package com.example.model.path;



import android.graphics.Color;

public class RailPath extends GenericPathStep<RailStep> {
	
	private Line m_Line;
	
	public RailPath(Line line) {
		super();
		m_Line = line;
	}

	public RailPath(Line line,RailStep ... steps) {
		super(steps);
		m_Line = line;
	}

	public Line getLine() {
		return m_Line;
	}

	@Override
	public int getColor() {
		return Color.GRAY;
	}


}

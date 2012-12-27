package com.example.model.path;

import java.util.ArrayList;
import java.util.List;


public abstract class GenericPathStep<T extends GenericStep> {
	protected List<T> m_Steps;
	protected GenericPathStep<?> m_nextStep;
	
	GenericPathStep(T ... steps) {
		m_Steps = new ArrayList<T>();
		int i;
		for (i=0;i<steps.length;i++) {			
			m_Steps.add(steps[i]);
			steps[i].setParent(this);
			if (i>0)
				steps[i-1].setNextStep(steps[i]);
		}				
	}

	public GenericPathStep<?> getNextStep() {
		return m_nextStep;
	}
	
	public void setNextStep(GenericPathStep<?> nextStep) {
		this.m_nextStep = nextStep;
	}

	public abstract int getColor();

	public List<T> getSteps() {
		return m_Steps;
	}	

}

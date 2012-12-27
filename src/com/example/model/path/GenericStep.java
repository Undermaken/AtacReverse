package com.example.model.path;

import java.util.Date;



public class GenericStep {
	protected String desc;
	protected GenericStep m_nextStep;
	private GenericPathStep<?> m_Parent;
	private Date eta;	
	
	public GenericStep() {
	}
	
	public GenericStep(String desc, Date eta) {
		this.desc = desc;
		this.eta = eta;
	}

	public GenericStep getNextStep() {
		return m_nextStep;
	}	
	
	public void setNextStep(GenericStep nextStep) {
		m_nextStep = nextStep;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public Date getEta() {
		return eta;
	}	
	
	public GenericPathStep<?> getParent() {
		return m_Parent;
	}
	
	public void setParent(GenericPathStep<?> parent) {
		m_Parent = parent;
	}
	
	public String getNextStepDesc() {
		if (getNextStep()!=null) {
			return getNextStep().getDesc();
		} else {
			if (m_Parent.getNextStep()!=null)
				return m_Parent.getNextStep().getSteps().get(0).getDesc();
			else
				return null;
		}
	}
	
}

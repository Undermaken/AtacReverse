package com.example.constants;

public enum EPropSpostPiediBici {
	BASSA(0), //CAMMINATORE LENTO
	MEDIA(1),
	ALTA(2); //CAMMINATORE VELOCE
	
	private final int ID;
	private EPropSpostPiediBici(final int id)
	{
		this.ID = id;
	}
	
	public int getID()
	{
		return this.ID;
	}
}

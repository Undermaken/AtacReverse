package com.example.constants;

public enum EQuando {
	ADESSO(0),
	FRA5MIN(1),
	GIORNO_ESATTO(2);
	
	private final int ID;
	private EQuando(final int id)
	{
		this.ID = id;
	}
	
	public int getID()
	{
		return this.ID;
	}
}

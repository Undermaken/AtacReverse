package com.example.atacreverse;

import java.util.Date;

import com.example.constants.EPropSpostPiediBici;
import com.example.constants.EQuando;

public class AtacSearchOption {

	private String optionString;
	
	//default constructor
	public AtacSearchOption()
	{
		this(new Date().getHours(), 
			new Date().getMinutes(),
			new Date().getDay(),
			true,
			true,
			true,
			true,
			true,
			true,
			5,
			EQuando.ADESSO,
			EPropSpostPiediBici.MEDIA);
		
	}
	
	public AtacSearchOption(int hours, 
			int minutes,
			int day_of_week, 
			boolean piedi, 
			boolean mezzi, 
			boolean metro,
			boolean bus,
			boolean ferrovie_atac, 
			boolean ferrovie_regionali,
			int max_distanza_bici,
			EQuando quando,
			EPropSpostPiediBici mobilita)
	{
		String h = String.valueOf(hours);
		String m = String.valueOf(minutes);
		String d = String.valueOf(day_of_week);
		String met = metro ? "on" : "off";
		String b = bus ? "on" : "off";
		String fer_atac = ferrovie_atac ? "on" : "off";
		String fer_regio  = ferrovie_regionali ? "on" : "off";
		String bici = String.valueOf(max_distanza_bici);
		optionString = "&quando="+quando.getID()+"&" +
				"wd="+d+"&" +
				"hour="+h+"&" +
				"minute="+m+"&" +
				"mezzo=1&" + //ALWAYS ON TRUE, MEANS: "MEZZI PUBBLICI"
				"piedi="+mobilita.getID()+"&" +
				"max_distanza_bici="+bici+"&" +
				"bus="+b+"&" +
				"metro="+met+"&" +
				"fc="+fer_atac+"&" +
				"fr="+fer_regio;
	}
	
	public String getOption()
	{
		return this.optionString;
	}
	
}

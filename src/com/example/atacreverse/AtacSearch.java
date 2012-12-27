package com.example.atacreverse;

import com.example.constants.Constats;


public class AtacSearch {

	private String from;
	private String from_num;
	private String to;
	private String to_num;
	private AtacSearchOption option;
	
	
	
	//passing -1 for civic number None/unknow
	public AtacSearch(String _from, int f_num, String _to, int t_num, AtacSearchOption opt)
	{
		this.from = _from.replace(" ", "+");
		this.to = _to.replace(" ", "+");
		this.from_num = f_num == -1 ? "" : ("+" + String.valueOf(f_num));
		this.to_num = t_num == -1 ? "" : ("+" + String.valueOf(t_num));
		this.option = opt;
	}
	
	public AtacSearch(String _from, int f_num, String _to, int t_num)
	{
		this(_from, f_num, _to, t_num, new AtacSearchOption());
	}
	
	public String getUrl()
	{
		return Constats.ATAC_PATH_SEARCH + 
				Constats.ATAC_START + this.from  + this.from_num +
				Constats.ATAC_STOP + this.to  +  this.to_num +
				this.option.getOption() +
				Constats.ATAC_END;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom_num() {
		return from_num;
	}

	public void setFrom_num(String from_num) {
		this.from_num = from_num;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTo_num() {
		return to_num;
	}

	public void setTo_num(String to_num) {
		this.to_num = to_num;
	}
	
	
	
	
	
	
	
}

package com.example.taks;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.atacreverse.AtacSearch;
import com.example.constants.Constats;
import com.example.model.path.BusStep;
import com.example.model.path.RailStep;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class SearchTask extends AsyncTask<AtacSearch, Void, Boolean> {

	private ProgressDialog dialog;
	private Context context;
	private TextView textview;
	private String resultString;
	
	public SearchTask(Context context,TextView t)
	{
		this.context = context;
		this.textview = t;
		this.resultString = "";
	}
	
	
	protected void onPreExecute()
	{
		dialog = new ProgressDialog(this.context);
		dialog.setTitle("Searching");
		dialog.setMessage("Loading...");
		dialog.show();
		
		this.textview.setText("");
	}
	
	@Override
	protected Boolean doInBackground(AtacSearch... arg0) {
		AtacSearch search = arg0[0];
    	Document doc;
    	boolean result = false;
		try {
			int hours = -1;
			int minutes = -1;
			double distance = -1;
			
			doc = Jsoup.connect(search.getUrl()).get();
			
			//GETTING DURATA VIAGGIO / DISTANZA PERCORSA
			Elements info = doc.select("p");
			for (Element element : info) {
				String html = element.html();
				String hook = "";
				if(html.contains("Durata spostamento"))
				{
					try 
					{
						result = true;
						hook = "</span>";
						html = html.substring(html.indexOf(hook) + hook.length() + 1);
						hook = "<br />";
						//html = html.substring(0,html.indexOf(hook));
						//SetResult("durata",html);
						if(html.contains("or"))
						{
							html = html.trim();
							hours = Integer.parseInt(html.substring(0,html.indexOf(" ")));
							hook = "or";
							html = html.substring(html.indexOf(hook) + hook.length() + 2);
							html = html.trim();
							if(html.contains("minut"))
								minutes = Integer.parseInt(html.substring(0,html.indexOf(" ")));
							SetResult("hours",String.valueOf(hours));
							SetResult("minutes",String.valueOf(minutes));
						}
						if(html.contains("Distanza percorsa"))
						{
							hook = "Distanza percorsa";
							html = html.substring(html.indexOf(hook) + hook.length());
							hook = "</span>:";
							html = html.substring(html.indexOf(hook) + hook.length());
							html = html.trim();
							String dis = html.substring(0,html.indexOf(" "));
							SetResult("distance",dis);
							distance = Double.parseDouble(dis);
						}
						
					}
					catch (Exception e) {
						Log.e("Exc in durata", e.getMessage());
						e.printStackTrace();
						return false;
					}
					
				}
			}
			
			
			Elements newsHeadlines = doc.select(".indicazioni tr");
			String src_dettagli;
			for (Element element : newsHeadlines) {
					Elements tr_elements = element.select("img");
					String img_src = tr_elements.get(0).attr("src");
					
					src_dettagli = "";
					if(img_src.contains("piedi"))
					{
						result = true;
						SetResult("Step","PIEDI");
						src_dettagli = element.select("td").get(1).select("a").attr("href");
						String descrizione = "";
						Document temp = Jsoup.connect(Constats.ATAC_PATH + src_dettagli).get();
						if(temp.select("#dettagli").parents().size() > 0)
						{
							descrizione += temp.select("#dettagli").parents().get(0).html();
							descrizione = Jsoup.parse(descrizione).text();
							SetResult("Descrizione-PIEDI", descrizione);
						}
						
					}
					else if(img_src.contains("nodo"))
					{
						SetResult("NODO","NODO");
						String descrizione = Jsoup.parse(element.select("td").get(1).html()).text();
						descrizione = descrizione.replace("(Mappa)", "").replace("(Sono qui)", "");
						if(descrizione.contains("("))
						{
							descrizione = descrizione.substring(descrizione.indexOf("(")+1);
							String bus_stop = descrizione.substring(0,descrizione.indexOf(")"));
							SetResult("Nodo-Bus",bus_stop);
						}
						else
						{
							String metro_stop = descrizione.replace("Stazione","");
							SetResult("Nodo-metro",metro_stop);
						}
						
					}
					else if(img_src.contains("metro"))
					{
						result = true;
						SetResult("Step","METRO");
						String descrizione = Jsoup.parse(element.select("td").get(1).html()).text();
						descrizione = descrizione.replace("(Escludi)", "");
						SetResult("Metro-Descrizione",descrizione);
						BusStep step = new BusStep("", null, 1);
						for (Element a_elem : element.select("td").get(1).select("a")) {
							if(a_elem.attr("href").contains("percorso/espandi"))
							{
								src_dettagli = a_elem.attr("href");
								break;
							}
						}
						//ottengo i dettagli
						if(src_dettagli.length() > 0)
						{
							Document temp = Jsoup.connect(Constats.ATAC_PATH + src_dettagli).get();
							String dettagli = temp.select("#dettagli").parents().get(0).html();
							String[] lines = dettagli.split("<br />");
							int i = 0;
							for (String string : lines) {
								if(i++ < 3)
									continue;
								SetResult("step-metro",Jsoup.parse(string).text());
							}
						}
					}
					else if(img_src.contains("bus"))
					{
						result = true;
						SetResult("Step","BUS");
						String descrizione = Jsoup.parse(element.select("td").get(1).html()).text();
						descrizione = descrizione.replace("(Escludi)", "");
						SetResult("Bus-Descrizione",descrizione);
						RailStep step = new RailStep("", null, null);
						for (Element a_elem : element.select("td").get(1).select("a")) {
							if(a_elem.attr("href").contains("percorso/espandi"))
							{
								src_dettagli = a_elem.attr("href");
								break;
							}
						}
						//ottengo i dettagli
						if(src_dettagli.length() > 0)
						{
							Document temp = Jsoup.connect(Constats.ATAC_PATH + src_dettagli).get();
							String dettagli = temp.select("#dettagli").parents().get(0).html();
							String[] lines = dettagli.split("<br />");
							int i = 0;
							for (String string : lines) {
								if(i++ < 3)
									continue;
								SetResult("step-bus",Jsoup.parse(string).text());
							}
						}
					}
					SetResult("\n","\n");
					//steps.add(step);
					//Distance dis = new Distance(foot, bustram, underground, urbanrailway, regionalrailways, total)
					//Path path = new Path(search.getTo(), distances, start, eta, steps)
			}
			SetResult("END","END");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			return false;
		}
		return result;
	}
	
	protected void onPostExecute(Boolean par)
	{
		
		if(dialog.isShowing())
		this.dialog.dismiss();
		if(par)
			this.textview.setText(this.resultString);
		else
			this.textview.setText("Some error occurred. Please Retry");
	}
	
	private void SetResult(String tag,String value)
	{
		if(tag.equals("\n"))
		{
			this.resultString += "\n";
		}
		else
		{
			this.resultString += tag + ": " + value;
			this.resultString += "\n";
		}
	}

}

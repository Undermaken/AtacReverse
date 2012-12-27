package com.example.atacreverse;

import com.example.taks.SearchTask;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SecondActivity extends Activity {
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.result);
	        TextView tv = (TextView)findViewById(R.id.text_view);
	        tv.setMovementMethod(new ScrollingMovementMethod());
	        Bundle bundle = getIntent().getExtras();
	        String from = bundle.getString("from");
	        String to = bundle.getString("to");
	        int from_num = bundle.getInt("from_num");
	        int to_num = bundle.getInt("to_num");
	        
	        SearchTask search = new SearchTask(this,tv);
	    	search.execute(new AtacSearch(from, from_num, to, to_num));
	        
	    }
	
	
}

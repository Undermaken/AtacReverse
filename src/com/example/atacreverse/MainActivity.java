package com.example.atacreverse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




import com.example.constants.Constats;
import com.example.model.path.BusStep;
import com.example.model.path.FootStep;
import com.example.model.path.GenericPathStep;
import com.example.model.path.GenericStep;
import com.example.model.path.Path;
import com.example.model.path.Path.Distance;
import com.example.model.path.RailStep;
import com.example.taks.SearchTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    
    public void Test(View v)
    {
    	String from = ((EditText)findViewById(R.id.from)).getText().toString();
    	String to = ((EditText)findViewById(R.id.to)).getText().toString();
    	int from_num = Integer.parseInt( ((EditText)findViewById(R.id.from_num)).getText().toString());
    	int to_num = Integer.parseInt( ((EditText)findViewById(R.id.to_num)).getText().toString());
        
    	Intent intent = new Intent(this,SecondActivity.class);
    	intent.putExtra("from", from);
    	intent.putExtra("from_num", from_num);
    	intent.putExtra("to", to);
    	intent.putExtra("to_num", to_num);
    	startActivity(intent);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

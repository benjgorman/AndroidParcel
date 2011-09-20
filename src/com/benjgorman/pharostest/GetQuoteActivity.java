package com.benjgorman.pharostest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GetQuoteActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.getquote);
              
        Spinner spinner = (Spinner) findViewById(R.id.spn_country);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.country_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());       
    }
}

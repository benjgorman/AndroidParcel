package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.array;
import com.benjgorman.pharostest.R.id;
import com.benjgorman.pharostest.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

public class GetQuoteActivity extends Activity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		
		setContentView(R.layout.getquote);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
               
        //Add a few countries to the spinner
       Spinner spinnerCountries = (Spinner) findViewById(R.id.spinner_collection_address);
       ArrayAdapter countryArrayAdapter = new ArrayAdapter(this,
                   android.R.layout.simple_spinner_dropdown_item,
                   new String[] { "UK", "Ireland", "Canada", "USA", "France", "Spain", "Germany", });
       spinnerCountries.setAdapter(countryArrayAdapter);
       
       //Add a few countries to the spinner
      Spinner spinnerWeight = (Spinner) findViewById(R.id.spinner_weight);
      ArrayAdapter weightArrayAdapter = new ArrayAdapter(this,
                  android.R.layout.simple_spinner_dropdown_item,
                  new String[] { "0.5kg", "1kg", "1.5kg", "2kg", "2.5kg", "3kg", "3.5kg", "4kg", });
      spinnerWeight.setAdapter(weightArrayAdapter);
        
        

        
        final Button button = (Button) findViewById(R.id.btn_quoteme);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
//            	Builder builder = new AlertDialog.Builder();
//                builder.setTitle("Quote");
//                builder.setMessage("Your quote is: ");
//                builder.setPositiveButton("Send this package", null);
//                builder.setNegativeButton("Cancel", null);
//                builder.show();                

            }
        });

        
       // spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());       
    }
}

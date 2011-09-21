package com.benjgorman.pharostest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.getquote);
               
        Spinner spinner = (Spinner) findViewById(R.id.spn_country);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.country_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        Spinner spinner2 = (Spinner) findViewById(R.id.spn_weight);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        
        final Button button = (Button) findViewById(R.id.btn_quoteme);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Builder builder = new AlertDialog.Builder();
                builder.setTitle("Quote");
                builder.setMessage("Your quote is: ");
                builder.setPositiveButton("Send this package", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();                
            }
        });
        
       // spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());       
    }
}

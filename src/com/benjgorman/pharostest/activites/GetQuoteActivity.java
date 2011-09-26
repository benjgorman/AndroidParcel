package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.SendParcel;
import com.benjgorman.pharostest.R.array;
import com.benjgorman.pharostest.R.id;
import com.benjgorman.pharostest.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.AlertDialog;

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
       
       //Add weight to the spinner
      Spinner spinnerWeight = (Spinner) findViewById(R.id.spinner_weight);
      ArrayAdapter weightArrayAdapter = new ArrayAdapter(this,
                  android.R.layout.simple_spinner_dropdown_item,
                  new String[] { "0.5kg", "1kg", "1.5kg", "2kg", "2.5kg", "3kg", "3.5kg", "4kg", });
      spinnerWeight.setAdapter(weightArrayAdapter);
        
      //Add services to the spinner
     Spinner spinnerService = (Spinner) findViewById(R.id.spinner_service);
     ArrayAdapter serviceArrayAdapter = new ArrayAdapter(this,
                 android.R.layout.simple_spinner_dropdown_item,
                 new String[] { "UPS: Standard", "UPS: Express", "UPS: Express Saver", "UPS: Expedited", "Yodel: Standard", "Yodel: Saturday Delivery", "Yodel: AM Delivery", "Yodel: PM Delivery", "Yodel: Evening Delivery", });
     spinnerService.setAdapter(serviceArrayAdapter);

        
     
        final Button button = (Button) findViewById(R.id.btn_quoteme);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {          	          	
            	
            	new AlertDialog.Builder(GetQuoteActivity.this).setMessage("Your parcel will cost £34.75. Would you like to send it?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                	public void onClick(DialogInterface arg0, int arg1) {          			         
//                		Intent intent = new Intent(context, SendParcel1.class);
//            				context.startActivity(intent);
                	}
                })
            	.setNeutralButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                arg0.dismiss();                                     }
                        }).show();          
            }
        });

        
       // spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());       
    }
}

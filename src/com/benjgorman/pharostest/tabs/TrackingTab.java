package com.benjgorman.pharostest.tabs;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.benjgorman.pharostest.DatabaseAdapter;
import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.id;
import com.benjgorman.pharostest.R.layout;
import com.benjgorman.pharostest.activites.TrackingHistory;
import com.benjgorman.pharostest.activites.TrackingResult;
import com.benjgorman.pharostest.activites.VoiceRecognitionDemo;
import com.benjgorman.pharostest.tools.IntentIntegrator;
import com.benjgorman.pharostest.tools.IntentResult;
//import android.content.pm.PackageManager;
//import android.content.pm.PackageInfo;
import android.view.*;


public class TrackingTab extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracking);
        
		// TextView tv1 = (TextView) findViewById(R.id.TextView01);
     	//tv1.setText("Barcode");

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            {
            	IntentIntegrator.initiateScan(TrackingTab.this);
            }
        
        });
        
        final Button button4 = (Button) findViewById(R.id.btn_track_history);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            {
		  		launchHistory();
            }
        
        });
        
        final Button button3 = (Button) findViewById(R.id.btn_text);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            { 
                	final EditText simpleEditText = (EditText) findViewById(R.id.editBarcode);
                	String trackingNo = simpleEditText.getText().toString();
                	beginTracking(trackingNo);
            }
        
        });
        
        final Button button2 = (Button) findViewById(R.id.btn_speak);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            {
                	Intent intent = new Intent(v.getContext(), VoiceRecognitionDemo.class);
                	startActivityForResult(intent, 0);
            }
        
        });
        
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
  		
    	 if (scanResult != null) 
    	 {
    		 String trackingNo = scanResult.getContents().toString();
    		 beginTracking(trackingNo);
    		 
    	  		
    		 //TextView tv1 = (TextView) findViewById(R.id.TextView01);
             //	tv1.setText("Your Tracking Number is: " + scanResult.getContents());
    	 }
    	  // else continue with any other code you need in the method
    	 
    	 }
    
    public void launchHistory()
    {
    	Intent intent = new Intent(this, TrackingHistory.class);
  		this.startActivity(intent);
    }
    
    public void beginTracking(String trackingNo)
    {
    	if (trackingNo!=null)
    	{
	    	DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
		  	db.insertOrder(trackingNo);
		  	
		  		Intent intent = new Intent(this, TrackingResult.class);
		  		this.startActivity(intent);
			}	
    	}

    }
    

  


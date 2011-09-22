package com.benjgorman.pharostest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.benjgorman.pharostest.VoiceRecognitionDemo;
//import android.content.pm.PackageManager;
//import android.content.pm.PackageInfo;
import android.view.*;


public class PharosParcelActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracking);
        
		 TextView tv1 = (TextView) findViewById(R.id.TextView01);
     	tv1.setText("Barcode");
     	
        
     	
     	
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	IntentIntegrator.initiateScan(PharosParcelActivity.this);
            }
        
    });
   
        
        final Button button2 = (Button) findViewById(R.id.btn_speak);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
                	Intent intent = new Intent(v.getContext(), VoiceRecognitionDemo.class);
                	startActivityForResult(intent, 0);

            }
        
    });
        
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    	 if (scanResult != null) {
    		 TextView tv1 = (TextView) findViewById(R.id.TextView01);
            	tv1.setText("Your Tracking Number is: " + scanResult.getContents());
    	 }
    	  // else continue with any other code you need in the method
    	 
    	 }
  
}

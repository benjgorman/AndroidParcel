package com.benjgorman.pharostest.tabs;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.benjgorman.pharostest.DatabaseAdapter;
import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.activites.TrackingHistory;
import com.benjgorman.pharostest.activites.TrackingResult;
import com.benjgorman.pharostest.tools.IntentIntegrator;
import com.benjgorman.pharostest.tools.IntentResult;
//import android.content.pm.PackageManager;
//import android.content.pm.PackageInfo;
import android.speech.RecognizerIntent;
import android.view.*;


public class TrackingTab extends Activity 
{
	private static final int REQUEST_CODE = 1234;
	private ListView wordsList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracking);
        
        Button speakButton = (Button) findViewById(R.id.btn_speak);
        
        wordsList = (ListView) findViewById(R.id.list);
 
        // Disable button if no recognition service is present
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0)
        {
            speakButton.setEnabled(false);
            speakButton.setText("Recognizer not present");
        }

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
//            @Override
			public void onClick(View v) 
            {
            	IntentIntegrator.initiateScan(TrackingTab.this);
            }
        
        });
        
        final Button button4 = (Button) findViewById(R.id.btn_track_history);
        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
			public void onClick(View v) 
            {
		  		launchHistory();
            }
        
        });
        
        final Button button3 = (Button) findViewById(R.id.btn_text);
        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
			public void onClick(View v) 
            { 
                	final EditText simpleEditText = (EditText) findViewById(R.id.editBarcode);
                	String trackingNo = simpleEditText.getText().toString();
                	beginTracking(trackingNo);
            }
        
        });
        
     
        
        
//        final Button button2 = (Button) findViewById(R.id.btn_speak);
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) 
//            {
//                	Intent intent = new Intent(v.getContext(), VoiceRecognitionDemo.class);
//                	startActivityForResult(intent, 0);
//            }
//        
//        });
        
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
  		
    	 if (scanResult != null) 
    	 {
    		 String trackingNo = scanResult.getContents().toString();
    		 beginTracking(trackingNo);
    		 
    		 //TextView tv1 = (TextView) findViewById(R.id.TextView01);
             //	tv1.setText("Your Tracking Number is: " + scanResult.getContents());
    	 }
    	 else if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
         {
             // Populate the wordsList with the String values the recognition engine thought it heard
             ArrayList<String> matches = intent.getStringArrayListExtra(
                     RecognizerIntent.EXTRA_RESULTS);
             
             String trackingNo = matches.get(0).toString();
             String [] anArray =  trackingNo.split("\\s+");
             trackingNo = "";
             
             for(int i=0; i< anArray.length; i++) {
            	 trackingNo = trackingNo + anArray[i];
             }
            	 
             beginTracking(trackingNo);
             
         }
         super.onActivityResult(requestCode, resultCode, intent);
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
		  		
		  		intent.putExtra("trackingNo",trackingNo);
		  		
		  		this.startActivity(intent);
		  		
			}	
    	}
    
    /**
     * Handle the action of the button being clicked
     */
    public void speakButtonClicked(View v)
    {
        startVoiceRecognitionActivity();
    }
 
    /**
     * Fire an intent to start the voice recognition activity.
     */
    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak your tracking number...");
        startActivityForResult(intent, REQUEST_CODE);
    }

}
    

  


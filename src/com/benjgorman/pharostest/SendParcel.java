package com.benjgorman.pharostest;

import com.benjgorman.pharostest.stores.AddressStore;
import com.benjgorman.pharostest.stores.OrderStore;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class SendParcel extends Activity implements OnTouchListener{

    float downXValue;
    private static final int MY_PASSWORD_DIALOG_ID = 4;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  

        // Set main.XML as the layout for this Activity
        setContentView(R.layout.sendparcel);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);

        // Add these two lines
        LinearLayout layMain = (LinearLayout) findViewById(R.id.layout_main);
        layMain.setOnTouchListener((OnTouchListener) this); 

         //Add a few countries to the spinner
        Spinner spinnerRecepient = (Spinner) findViewById(R.id.spinner_recepient_address);
        ArrayAdapter receArrayAdapter = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_dropdown_item,
                    new String[] { "7 Spey Grove, Glasgow", "12 Oakland Avenue, London" });
        spinnerRecepient.setAdapter(receArrayAdapter);

        Spinner spinnerCollection = (Spinner) findViewById(R.id.spinner_collection_address);       
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        Cursor addressCursor = db.getAddressCursor();
        
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.spinner_dropdown,   addressCursor,               
                new String[] { AddressStore.LINE1 },         
                new int[] {R.id.spinItem}); 
        
        spinnerCollection.setAdapter(adapter);
        
        Spinner spinnerServices = (Spinner) findViewById(R.id.spinner_service);
        ArrayAdapter servicesArrayAdapter = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_dropdown_item,
                    new String[] { "UPS Standard (UK 1-2 Working Days, Europe 1-5 Working Days)", "UPS Express (UK Next Working Day, ROW 1-3 Working Days)", "UPS Express Saver (UK Next Working Day, ROW 2-4 Working Days)", "UPS	Expedited (Rest Of World 2-7 Working Days)", "Yodel	Standard Service 1 -3 Working Days", "Yodel	Saturday delivery service", "Yodel AM Delivery 1 - 3 Working Days","Yodel PM Delivery 1 - 3 Working Days","Yodel Evening Delivery, 1 - 3 Working Days", "Yodel Avoid School Run Delivery, 1 - 3 Working Days", "Yodel	 Northern Ireland Standard Service 1-5 Working Days", });
        spinnerServices.setAdapter(servicesArrayAdapter);
        
        
        final Button button5 = (Button) findViewById(R.id.btn_addAddress);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            {
            	Context mContext = v.getContext();
            	final Dialog dialog = new Dialog(mContext);

            	dialog.setContentView(R.layout.add_address);
            	dialog.setTitle("Add Address");
            	
            	final Button button10 = (Button) dialog.findViewById(R.id.btn_cancel_address);
                button10.setOnClickListener(new View.OnClickListener() {
                	public void onClick(View v) 
                    {

                    	dialog.dismiss();
                    }
                
                });
                
                final Button button11 = (Button) dialog.findViewById(R.id.btn_save_address);
                button11.setOnClickListener(new View.OnClickListener() {
                	public void onClick(View v) 
                    {
                		EditText simpleEditText;
                		
                		simpleEditText = (EditText) dialog.findViewById(R.id.txtline1);
                    	String line1 = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtline2);
                    	String line2 = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtline3);
                    	String line3 = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtCity);
                    	String city = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtCounty);
                    	String region = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtPostcode);
                    	String postcode = simpleEditText.getText().toString();
                    	
                    	String country = "United Kingdom";

                		DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
                		AddressStore address = new AddressStore(line1, line2, line3, region, city, country, postcode);
            		  	db.insertAddress(address);
            		  	
            		  	dialog.dismiss();
                    }
                
                });

            	
            	dialog.show();
            }
        
        });
        
        final Button button6 = (Button) findViewById(R.id.btn_addRAddress);
        button6.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) 
            {
            	Context mContext = v.getContext();
            	final Dialog dialog = new Dialog(mContext);

            	dialog.setContentView(R.layout.add_address);
            	dialog.setTitle("Add Address");
            	
            	
            	final Button button9 = (Button) dialog.findViewById(R.id.btn_cancel_address);
                button9.setOnClickListener(new View.OnClickListener() {
                	@Override  
                	public void onClick(View v) 
                    {

                    	dialog.dismiss();
                    }
                
                });
                
                dialog.show();
                
            	
            }
        
        });
        
        final Button button7 = (Button) findViewById(R.id.btn_accept);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            {
            	Context mContext = v.getContext();
            	Dialog dialog = new Dialog(mContext);

            	dialog.setContentView(R.layout.order_options);
            	dialog.setTitle("What will you do now?");

            	
            	dialog.show();
            }
        
        });      
        
        
    
  
        // TODO: Create Dialog here and return it (see subsequent steps)

    }
    

    public boolean onTouch(View arg0, MotionEvent arg1) {

        // Get the action that was done on this touch event
        switch (arg1.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                // store the X value when the user's finger was pressed down
                downXValue = arg1.getX();
                break;
            }

            case MotionEvent.ACTION_UP:
            {
                // Get the X value when the user released his/her finger
                float currentX = arg1.getX();            

                // going backwards: pushing stuff to the right
                if (downXValue < currentX)
                {
                    // Get a reference to the ViewFlipper
                     ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
                     // Set the animation
                     vf.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_right));
                      // Flip!
                      vf.showPrevious();
                }

                // going forwards: pushing stuff to the left
                if (downXValue > currentX)
                {
                    // Get a reference to the ViewFlipper
                    ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
                     // Set the animation
                    	vf.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_left));
                      // Flip!
                     vf.showNext();
                }
                break;
            }
        }

        // if you return false, these actions will not be recorded
        return true;
    }

}

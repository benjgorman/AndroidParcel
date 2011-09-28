package com.benjgorman.pharostest;

import com.benjgorman.pharostest.activites.Checkout;
import com.benjgorman.pharostest.activites.FAQ;
import com.benjgorman.pharostest.stores.AddressStore;
import com.benjgorman.pharostest.stores.DetailsStore;
import com.benjgorman.pharostest.stores.RAddressStore;
import com.benjgorman.pharostest.stores.RDetailsStore;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class SendParcel extends Activity implements OnTouchListener{

    float downXValue;
    private static final int MY_PASSWORD_DIALOG_ID = 4;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  

        // Set main.XML as the layout for this Activity
        setContentView(R.layout.sendparcel);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);

        // Add these two lines
        LinearLayout layMain = (LinearLayout) findViewById(R.id.layout_main);
        layMain.setOnTouchListener(this); 

        setCollectionAddressSpinner();
        setRecepientAddressSpinner();
        setServicesSpinner();
        setDetailsSpinner();
        
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
            		  	
            		  	setCollectionAddressSpinner();
            		  	
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
            	dialog.setTitle("Add Recepient Address");
            	
            	
            	final Button button9 = (Button) dialog.findViewById(R.id.btn_cancel_address);
                button9.setOnClickListener(new View.OnClickListener() {
                	 
                	public void onClick(View v) 
                    {

                    	dialog.dismiss();
                    }
                
                });
                
                final Button button12 = (Button) dialog.findViewById(R.id.btn_save_address);
                button12.setOnClickListener(new View.OnClickListener() {
                	
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
                		RAddressStore address = new RAddressStore(line1, line2, line3, region, city, country, postcode);
            		  	db.insertRAddress(address);
            		  	
            		  	setRecepientAddressSpinner();
            		  	
            		  	dialog.dismiss();
                    }
                
                });

            	
            	dialog.show();
                
            	
            }
        
        });
        
        final Button button8 = (Button) findViewById(R.id.btn_add_details);
        button8.setOnClickListener(new View.OnClickListener() {
        	
			public void onClick(View v) 
            {
            	Context mContext = v.getContext();
            	final Dialog dialog = new Dialog(mContext);

            	dialog.setContentView(R.layout.add_details);
            	dialog.setTitle("Add Your Details");
            	
            	
            	final Button button9 = (Button) dialog.findViewById(R.id.btn_cancel_details);
                button9.setOnClickListener(new View.OnClickListener() {
                	 
                	public void onClick(View v) 
                    {

                    	dialog.dismiss();
                    }
                
                });
                
                final Button button12 = (Button) dialog.findViewById(R.id.btn_save_details);
                button12.setOnClickListener(new View.OnClickListener() {
                	
					public void onClick(View v) 
                    {
                		EditText simpleEditText;
                		
                		simpleEditText = (EditText) dialog.findViewById(R.id.txtTitle);
                    	String title = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtForename);
                    	String forename = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtSurname);
                    	String surname = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtPhone);
                    	String phone = simpleEditText.getText().toString();
                    	

                		DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
                		DetailsStore details = new DetailsStore(title, forename, surname, phone);
            		  	db.insertDetails(details);
            		  	
            		  	setDetailsSpinner();
            		  	
            		  	dialog.dismiss();
                    }
                
                });

            	
            	dialog.show();
            	
            }
        
        });
        
        final Button button12 = (Button) findViewById(R.id.btn_add_rdetails);
        button12.setOnClickListener(new View.OnClickListener() {
        	
			public void onClick(View v) 
            {
            	Context mContext = v.getContext();
            	final Dialog dialog = new Dialog(mContext);

            	dialog.setContentView(R.layout.add_rdetails);
            	dialog.setTitle("Add Recepient Details");
            	
            	
            	final Button button9 = (Button) dialog.findViewById(R.id.btn_cancel_details);
                button9.setOnClickListener(new View.OnClickListener() {
                	 
                	public void onClick(View v) 
                    {

                    	dialog.dismiss();
                    }
                
                });
                
                final Button button12 = (Button) dialog.findViewById(R.id.btn_save_details);
                button12.setOnClickListener(new View.OnClickListener() {
                	
					public void onClick(View v) 
                    {
                		EditText simpleEditText;
                		
                		simpleEditText = (EditText) dialog.findViewById(R.id.txtTitle);
                    	String title = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtForename);
                    	String forename = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtSurname);
                    	String surname = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtPhone);
                    	String phone = simpleEditText.getText().toString();
                    	

                		DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
                		RDetailsStore details = new RDetailsStore(title, forename, surname, phone);
            		  	db.insertRDetails(details);
            		  	
            		  	setRDetailsSpinner();
            		  	
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
				final Context mContext = v.getContext();               
            	final Dialog dialog = new Dialog(mContext);   
            	
				EditText nameEdit = (EditText) findViewById(R.id.txtWeight);
		    	String sName = nameEdit.getText().toString();
		    	
		        if (sName.matches("")) {
		        	Toast.makeText(mContext, "You have not entered a weight!", Toast.LENGTH_SHORT).show();
		        	return;
		        }
		        else
		        {
		                         	
	            	dialog.setContentView(R.layout.order_options);
	            	dialog.setTitle("What will you do now?");
	            	
	            	
	            	 final Button button12 = (Button) dialog.findViewById(R.id.btn_go_checkout);
	                 button12.setOnClickListener(new View.OnClickListener() {
	                 	
	                	 
	 					public void onClick(View v) 
	                     { 	
	
	                 		Intent intent = new Intent(mContext, Checkout.class);
	       			        mContext.startActivity(intent);
	       			        
	             		  	dialog.dismiss();
	                     }
	                 
	                 });
	
	            	
	            	dialog.show();
		        }
            }
        
        });      
        
    }
    
    private void setServicesSpinner() {
    	
    	Spinner spinnerServices = (Spinner) findViewById(R.id.spinner_service);
    	spinnerServices.setPrompt("Select a service...");
    	
        ArrayAdapter servicesArrayAdapter = new ArrayAdapter<Object>(this,
                    R.layout.spinner_dropdown,
                    new String[] { "UPS Standard (UK 1-2 Working Days, Europe 1-5 Working Days)", "UPS Express (UK Next Working Day, ROW 1-3 Working Days)", "UPS Express Saver (UK Next Working Day, ROW 2-4 Working Days)", "UPS	Expedited (Rest Of World 2-7 Working Days)", "Yodel	Standard Service 1 -3 Working Days", "Yodel	Saturday delivery service", "Yodel AM Delivery 1 - 3 Working Days","Yodel PM Delivery 1 - 3 Working Days","Yodel Evening Delivery, 1 - 3 Working Days", "Yodel Avoid School Run Delivery, 1 - 3 Working Days", "Yodel	 Northern Ireland Standard Service 1-5 Working Days", });
        spinnerServices.setAdapter(servicesArrayAdapter);
		
	}

	public void setCollectionAddressSpinner() {
    
    	Spinner s2 = (Spinner) findViewById(R.id.spinner_collection_address);
    	s2.setPrompt("Select an address...");
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        
        Cursor cur = db.getAddressCursor();
             
        final SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,
            R.layout.address_view, // Use a template
                                                  // that displays a
                                                  // text view
            cur, // Give the cursor to the list adapter
            new String[] {AddressStore.LINE1, AddressStore.POSTCODE, AddressStore.CITY}, // Map the NAME column in the
                                                 // people database to...
            new int[] {R.id.tvDBViewRow, R.id.tvDBViewRow1, R.id.tvDBViewRow3}); // The "text1" view defined in
                                             // the XML template
                                                 
        adapter2.setDropDownViewResource(R.layout.address_view);
        s2.setAdapter(adapter2);
    }
    
    public void setRecepientAddressSpinner() {
        
    	Spinner s2 = (Spinner) findViewById(R.id.spinner_recepient_address);
    	s2.setPrompt("Select an address...");
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        
        Cursor cur = db.getRAddressCursor();
             
        final SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,
            R.layout.address_view, // Use a template
                                                  // that displays a
                                                  // text view
            cur, // Give the cursor to the list adapter
            new String[] {RAddressStore.LINE1, RAddressStore.POSTCODE, RAddressStore.CITY}, // Map the NAME column in the
                                                 // people database to...
            new int[] {R.id.tvDBViewRow, R.id.tvDBViewRow1, R.id.tvDBViewRow3}); // The "text1" view defined in
                                             // the XML template
                                                 
        adapter2.setDropDownViewResource(R.layout.address_view);
        s2.setAdapter(adapter2);
    }
    
    public void setDetailsSpinner() {
	
    	Spinner s2 = (Spinner) findViewById(R.id.spinner_details);
    	s2.setPrompt("Select your details...");
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        
        Cursor cur = db.getDetailsCursor();
             
        final SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,
            R.layout.details_row, // Use a template
                                                  // that displays a
                                                  // text view
            cur, // Give the cursor to the list adapter
            new String[] {DetailsStore.TITLE,DetailsStore.FORENAME, DetailsStore.SURNAME, DetailsStore.PHONE, DetailsStore.EMAIL}, // Map the NAME column in the
                                                 // people database to...
            new int[] {R.id.tvDBViewRow, R.id.tvDBViewRow1, R.id.tvDBViewRow2, R.id.tvDBViewRow3, R.id.tvDBViewRow4}); // The "text1" view defined in
                                             // the XML template
                                                 
        adapter2.setDropDownViewResource(R.layout.details_row);
        s2.setAdapter(adapter2);
    }
    
    public void setRDetailsSpinner() {
    	
    	Spinner s2 = (Spinner) findViewById(R.id.spinner_rdetails);
    	s2.setPrompt("Select recepient details...");
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        
        Cursor cur = db.getRDetailsCursor();
             
        final SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,
            R.layout.details_row, // Use a template
                                                  // that displays a
                                 // text view
            cur, // Give the cursor to the list adapter
            new String[] {RDetailsStore.TITLE, RDetailsStore.FORENAME, RDetailsStore.SURNAME, RDetailsStore.PHONE}, // Map the NAME column in the
                                                 // people database to...
            new int[] {R.id.tvDBViewRow, R.id.tvDBViewRow1, R.id.tvDBViewRow2, R.id.tvDBViewRow3}); // The "text1" view defined in
                                             // the XML template
                                                 
        adapter2.setDropDownViewResource(R.layout.details_row);
        s2.setAdapter(adapter2);
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

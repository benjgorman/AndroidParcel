package com.benjgorman.pharostest.activites;

import java.util.ArrayList;
import java.util.HashMap;

import com.benjgorman.pharostest.DatabaseAdapter;
import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.stores.PaymentStore;
import com.benjgorman.pharostest.stores.RAddressStore;
import com.benjgorman.pharostest.stores.RDetailsStore;
import com.benjgorman.pharostest.tablayout.TabBar;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class Checkout extends ListActivity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		
		setContentView(R.layout.payment);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
        setPaymentSpinner();
        
        final Button button6 = (Button) findViewById(R.id.btn_addCard);
        button6.setOnClickListener(new View.OnClickListener() {
        	
			public void onClick(View v) 
            {
            	Context mContext = v.getContext();
            	final Dialog dialog = new Dialog(mContext);

            	dialog.setContentView(R.layout.add_payment);
            	dialog.setTitle("Add Payment");
            	
            	
            	final Button button9 = (Button) dialog.findViewById(R.id.btn_cancelpay);
                button9.setOnClickListener(new View.OnClickListener() {
                	 
                	public void onClick(View v) 
                    {

                    	dialog.dismiss();
                    }
                
                });
                
                final Button button12 = (Button) dialog.findViewById(R.id.btn_savepay);
                button12.setOnClickListener(new View.OnClickListener() {
                	
					public void onClick(View v) 
                    {
                		EditText simpleEditText;
                		
                		simpleEditText = (EditText) dialog.findViewById(R.id.txtCardName);
                    	String name = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtPayType);
                    	String type = simpleEditText.getText().toString();
                    	
                    	simpleEditText = (EditText) dialog.findViewById(R.id.txtCardNo);
                    	String number = simpleEditText.getText().toString();
                    	
                		DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
                		PaymentStore address = new PaymentStore(number, name, type);
            		  	db.insertPayment(address);
            		  	
            		  	setPaymentSpinner();
            		  	
            		  	dialog.dismiss();
                    }
                
                });

            	
            	dialog.show();
                
            	
            }
        
        });
        
        final Button button0 = (Button) findViewById(R.id.btn_complete);
        button0.setOnClickListener(new View.OnClickListener() {
                 	           
			public void onClick(View v) 
            {
				Intent intent = new Intent(v.getContext(), TabBar.class);
				startActivity(intent);
				
            }
        
        });
        
        Button buttonNext = (Button) findViewById(R.id.btn_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
//            @Override
  		public void onClick(View view) {
                // Get the ViewFlipper from the layout
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.quote);

                // Set an animation from res/anim: I pick push left in
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_left));
                vf.showNext();
        }
        });
        
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("service", "Total: \t");
        map.put("price", "£8.33");
        mylist.add(map);
        map = new HashMap<String, String>();
        map.put("service", "VAT: \t");
        map.put("price", "£2.59");
        mylist.add(map);
        map = new HashMap<String, String>();
        map.put("service", "Subtotal: \t");
        map.put("price", "£10.92");
        mylist.add(map);
      
        
        SimpleAdapter mSchedule = new SimpleAdapter(this, mylist, R.layout.quote_row,
                    new String[] {"service", "price"}, new int[] {R.id.SERVICE_CELL, R.id.PRICE_CELL});
        setListAdapter(mSchedule);
        
               
	}
	
    public void setPaymentSpinner() {
    	
    	Spinner s2 = (Spinner) findViewById(R.id.spinner_card);
    	s2.setPrompt("Select your card...");
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        
        Cursor cur = db.getPaymentCursor();
             
        final SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,
            R.layout.details_row2, // Use a template
                                                  // that displays a
                                                  // text view
            cur, // Give the cursor to the list adapter
            new String[] {PaymentStore.NUMBER,PaymentStore.NAME, PaymentStore.TYPE}, // Map the NAME column in the
                                                 // people database to...
            new int[] {R.id.tvDBViewRow, R.id.tvDBViewRow1, R.id.tvDBViewRow2}); // The "text1" view defined in
                                             // the XML template
        boolean isEmpty = adapter2.isEmpty();                                 
        if (isEmpty == false)
        {
        	adapter2.setDropDownViewResource(R.layout.details_row2);
        	s2.setAdapter(adapter2);
        }
        else
        {
        	ArrayAdapter servicesArrayAdapter = new ArrayAdapter<Object>(this,
                    R.layout.spinner_dropdown,
                    new String[] {"Tap the button on the right to add your Payment Details"});
        	s2.setAdapter(servicesArrayAdapter);
        }
    }
	
}
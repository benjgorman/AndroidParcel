package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.DatabaseAdapter;
import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.stores.PaymentStore;
import com.benjgorman.pharostest.stores.RAddressStore;
import com.benjgorman.pharostest.stores.RDetailsStore;
import com.benjgorman.pharostest.tablayout.TabBar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class Checkout extends Activity{
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
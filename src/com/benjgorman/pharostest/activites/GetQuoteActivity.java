package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.SendParcel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ViewFlipper;
import android.app.ListActivity;

public class GetQuoteActivity extends ListActivity{
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
      
      Button buttonNext = (Button) findViewById(R.id.btn_quoteme);
      buttonNext.setOnClickListener(new View.OnClickListener() {
//          @Override
		public void onClick(View view) {
              // Get the ViewFlipper from the layout
              ViewFlipper vf = (ViewFlipper) findViewById(R.id.quote);

              // Set an animation from res/anim: I pick push left in
              vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_left));
              vf.showNext();
      }
      });

      // Set the listener for Button_Previous, a quick and dirty way to create a listener
      Button buttonPrevious = (Button) findViewById(R.id.btn_back);
      buttonPrevious.setOnClickListener(new View.OnClickListener() {
//          @Override
		public void onClick(View view) {
              // Get the ViewFlipper from the layout
              ViewFlipper vf = (ViewFlipper) findViewById(R.id.quote);
              // Set an animation from res/anim: I pick push left out
              vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_right));
              vf.showPrevious();
      }

      });        
      
      setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
              R.array.services, R.layout.list_item));
      
      
       
            	
        }
	
	// ListView and view (row) on which was clicked, position and
			@Override
			protected void onListItemClick(ListView l, View v, int position, long id) {
				super.onListItemClick(l, v, position, id);
				
				Intent i = new Intent(this, SendParcel.class);
			  	this.startActivity(i);
			    
			}
        
     
}
	
	


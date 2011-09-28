package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public class Checkout extends Activity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		
		setContentView(R.layout.payment);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
               
	}
	
}
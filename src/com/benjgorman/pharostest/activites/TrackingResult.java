package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

public class TrackingResult extends Activity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		
		setContentView(R.layout.tracking_result);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
               
	}
}


package com.benjgorman.pharostest.tabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.activites.AccordianSampleActivity;
import com.benjgorman.pharostest.activites.GetQuoteActivity;

public class ServicesTab extends Activity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.services);
        
        
        Button next = (Button) findViewById(R.id.btn_getquote);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AccordianSampleActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });
        
        
        
    }
}

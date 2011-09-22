package com.benjgorman.pharostest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SendPackageActivity extends Activity{
	
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
     //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
        
        
        setContentView(R.layout.sendpackage);
     //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        context = this;
        
        Button button = (Button)findViewById(R.id.btn_getquote);
        button.setOnClickListener(
           	new OnClickListener()
            	{
    				public void onClick(View v) {
    				Intent intent = new Intent(context, GetQuoteActivity.class);
   			        context.startActivity(intent);
    				}	
           	}
         );
        
        Button button2 = (Button)findViewById(R.id.btn_sendpackage);
        button2.setOnClickListener(
           	new OnClickListener()
            	{
    				public void onClick(View v) {
    				Intent intent = new Intent(context, SendParcel1.class);
   			        context.startActivity(intent);
    				}	
           	}
         );
    }
}

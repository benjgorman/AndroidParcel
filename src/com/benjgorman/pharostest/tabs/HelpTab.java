package com.benjgorman.pharostest.tabs;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.SendParcel2;
import com.benjgorman.pharostest.R.layout;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpTab extends Activity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
                
        Button button = (Button)findViewById(R.id.btn_email);
        button.setOnClickListener(
           	new OnClickListener()
            	{
    				public void onClick(View v) {
    					Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

    					String aEmailList[] = { "norrehlienad90@hotmail.com" };
    					String aEmailCCList[] = { "" };
    					String aEmailBCCList[] = { "" };

    					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
    					emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
    					emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);

    					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Additional Question");

    					emailIntent.setType("plain/text");
    					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");

    					startActivity(emailIntent);
    				}	
           	}
         );
        
    }
}


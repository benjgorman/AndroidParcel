package com.benjgorman.pharostest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SendParcel1 extends Activity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.sendparcel1);
        context  = this;

        Button button = (Button)findViewById(R.id.btn_usethisaddress);
        button.setOnClickListener(
           	new OnClickListener()
            	{
    				public void onClick(View v) {
    				Intent intent = new Intent(context, SendParcel2.class);
   			        context.startActivity(intent);
    				}	
           	}
         );
        
    }
	
	public void checkResidential(View checkbox)
	{
			final CheckBox residential = (CheckBox) findViewById(R.id.residential);
		
		if (residential.isChecked()){
			EditText company = (EditText) findViewById(R.id.companyname);
			company.setText("Residential");
			final EditText companyname = (EditText) findViewById(R.id.companyname);
			companyname.setEnabled(true);
		}
		
		if (!residential.isChecked()){
			EditText company = (EditText) findViewById(R.id.companyname);
			company.setText("");
			final EditText companyname = (EditText) findViewById(R.id.companyname);
			companyname.setEnabled(true);
		}
	}
	
}

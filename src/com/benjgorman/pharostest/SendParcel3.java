package com.benjgorman.pharostest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class SendParcel3 extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.sendparcel3);

    }
	
//	public void checkResidential(View checkbox)
//	{
//			final CheckBox residential = (CheckBox) findViewById(R.id.residential);
//		
//		if (residential.isChecked()){
//			EditText company = (EditText) findViewById(R.id.companyname);
//			company.setText("Residential");
//			final EditText companyname = (EditText) findViewById(R.id.companyname);
//			companyname.setEnabled(true);
//		}
//		
//		if (!residential.isChecked()){
//			EditText company = (EditText) findViewById(R.id.companyname);
//			company.setText("");
//			final EditText companyname = (EditText) findViewById(R.id.companyname);
//			companyname.setEnabled(true);
//		}
//	}
	
}

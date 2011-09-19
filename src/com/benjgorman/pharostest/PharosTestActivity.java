package com.benjgorman.pharostest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PharosTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
         TextView tv = new TextView(this);
         tv.setText("Hello, BEEEn");
         setContentView(tv);
         
         Log.d("Pharos", "HELP BROKEN");
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	Log.d("Pharos", "HELP BROKEN");
    }
}

package com.benjgorman.pharostest.activites;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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
        
        generateMap("http://maps.googleapis.com/maps/api/staticmap?center=Glenrothes,UK&zoom=14&size=400x200&sensor=false");
        
        TextView t = (TextView)findViewById(R.id.lblTrackingNo);
        t.setText("trackingNo");
               
	}
	
	public String getTrackingNo()
	{
		Bundle extras = getIntent().getExtras();
		if(extras !=null) 
		{
			String value = extras.getString("trackingNo");
			return value;
		}
		return null;
	}
	
	public void generateMap(String fileUrl)
	{
		Bitmap bmImg;
        URL myFileUrl = null;          
        try {
             myFileUrl= new URL(fileUrl);
        } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
        try {
             HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
             conn.setDoInput(true);
             conn.connect();
             InputStream is = conn.getInputStream();
             
             bmImg = BitmapFactory.decodeStream(is);
             ImageView i = (ImageView) findViewById(R.id.ivTrackingMap);
             i.setImageBitmap(bmImg);
        } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
   }
}


package com.benjgorman.pharostest.activites;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.benjgorman.pharostest.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TrackingResult extends ListActivity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		
		setContentView(R.layout.tracking_result);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
        TextView t = (TextView)findViewById(R.id.lblTrackingNo);
        
        String value = null;
        Bundle extras = getIntent().getExtras();
		if(extras !=null) 
		{
			value = extras.getString("trackingNo");
		}
		
        t.setText(value);
        
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("date", "28 Sep 2011");
        map.put("time", "10:22:01 AM");
        map.put("location", "Delivery Address");
        map.put("event", "Delivered");
        mylist.add(map);
        map = new HashMap<String, String>();
        map.put("date", "28 Sep 2011");
        map.put("time", "05:22:46 AM");
        map.put("location", "Dundee East DO");
        map.put("event", "Out for delivery");
        mylist.add(map);
        map = new HashMap<String, String>();
        map.put("date", "27 Sep 2011");
        map.put("time", "07:03:39 AM");
        map.put("location", "Edinburgh Mail Centre");
        map.put("event", "Arrival Scan");
        mylist.add(map);
        map = new HashMap<String, String>();
        map.put("date", "26 Sep 2011");
        map.put("time", "02:47:06 PM");
        map.put("location", "Scottish Distribution Centre");
        map.put("event", "Arrival Scan");
        mylist.add(map);
        map = new HashMap<String, String>();
        map.put("date", "26 Sep 2011");
        map.put("time", "11:54:40 AM");
        map.put("location", "Gourock Inverclyde UK");
        map.put("event", "Order has been handed over to the carrier and is in transit");
        mylist.add(map);
      
        
        SimpleAdapter mSchedule = new SimpleAdapter(this, mylist, R.layout.tracking_row,
                    new String[] {"date", "time", "location", "event"}, new int[] {R.id.DATE_CELL, R.id.TIME_CELL, R.id.LOCATION_CELL, R.id.EVENT_CELL});
        setListAdapter(mSchedule);
               
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


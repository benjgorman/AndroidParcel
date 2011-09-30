package com.benjgorman.pharostest.tablayout;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.tabs.HelpTab;
import com.benjgorman.pharostest.tabs.HistoryTab;
import com.benjgorman.pharostest.tabs.PackagesTab;
import com.benjgorman.pharostest.tabs.ServicesTab;
import com.benjgorman.pharostest.tabs.TrackingTab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TabBar  extends ScrollableTabActivity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        /*
         * set this activity as the tab bar delegate
         * so that onTabChanged is called when users tap on the bar
         */
        setDelegate(new SliderBarActivityDelegateImpl());
        
        for (int i=0; i<=6; i++)
        {
        	Intent intent;
        	
        	 switch (i) {

             case 1: 
            	 intent = new Intent(this, PackagesTab.class);
            	 this.addTab("Packages", R.drawable.packages_up, R.drawable.packages_down, intent);;   
            	 break;
             case 2: 
            	 intent = new Intent(this, TrackingTab.class);
            	 this.addTab("Tracking", R.drawable.tracking_up, R.drawable.tracking_down, intent);;      
            	 break;
             case 3: 
            	 intent = new Intent(this, HistoryTab.class);
            	 this.addTab("History", R.drawable.history_up, R.drawable.history_down, intent);;       
            	 break;
             case 4:
            	 intent = new Intent(this, ServicesTab.class);
            	 this.addTab("Services", R.drawable.services_up, R.drawable.services_down, intent);;       
            	 break;
             case 5:
            	 intent = new Intent(this, HelpTab.class);
            	 this.addTab("Help", R.drawable.help_up, R.drawable.help_down, intent);;       
            	 break;
            
             default:; break;
         }
        	
        }
        
       
        commit(); //redraws bar
    }
 
    private class SliderBarActivityDelegateImpl extends SliderBarActivityDelegate
    {
    	@Override
		protected void onTabChanged(int tabIndex) 
    	{
    		Log.d("onTabChanged",""+tabIndex);
    	}
    }
}
package com.benjgorman.pharostest.tablayout;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.drawable;
import com.benjgorman.pharostest.tabs.HelpTab;
import com.benjgorman.pharostest.tabs.HistoryTab;
import com.benjgorman.pharostest.tabs.PackagesTab;
import com.benjgorman.pharostest.tabs.ServicesTab;
import com.benjgorman.pharostest.tabs.TrackingTab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


/*
 * This activity demonstrates the use of ScrollableTabActivity by extending the class
 * 
 * Required files:
 * ScrollableTabActivity.java
 * RadioStateDrawable.java
 * TabBarButton.java
 * res/drawable/bottom_bar_highlight.9.png
 * res/drawable/bottom_bar.9.png
 * res/drawable/scrollbar_horizontal_thumb.xml
 * res/drawable/scrollbar_horizontal_track.xml
 * res/layout/customslidingtabhost.xml
 * res/layout/scrollgroupradiobuttonview.xml
 */
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
        	
        	/*
        	 * This adds a title and an image to the tab bar button
        	 * Image should be a PNG file with transparent background.
        	 * Shades are opaque areas in on and off state are specific as parameters
        	 */
        	 switch (i) {

             case 1: 
            	 intent = new Intent(this, PackagesTab.class);
            	 this.addTab("Packages", R.drawable.tabup, R.drawable.tabdown, intent);;   
            	 break;
             case 2: 
            	 intent = new Intent(this, TrackingTab.class);
            	 this.addTab("Tracking", R.drawable.tabup, R.drawable.tabdown, intent);;      
            	 break;
             case 3: 
            	 intent = new Intent(this, HistoryTab.class);
            	 this.addTab("History", R.drawable.tabup, R.drawable.tabdown, intent);;       
            	 break;
             case 4:
            	 intent = new Intent(this, ServicesTab.class);
            	 this.addTab("Services", R.drawable.tabup, R.drawable.tabdown, intent);;       
            	 break;
             case 5:
            	 intent = new Intent(this, HelpTab.class);
            	 this.addTab("Help", R.drawable.tabup, R.drawable.tabdown, intent);;       
            	 break;
            
             default:; break;
         }
        	
        }
        
        /*
         * commit is required to redraw the bar after add tabs are added
         * if you know of a better way, drop me your suggestion please.
         */
        commit();
    }
 
    private class SliderBarActivityDelegateImpl extends SliderBarActivityDelegate
    {
    	/*
    	 * Optional callback method
    	 * called when users tap on the tab bar button
    	 */
    	protected void onTabChanged(int tabIndex) 
    	{
    		Log.d("onTabChanged",""+tabIndex);
    	}
    }
}
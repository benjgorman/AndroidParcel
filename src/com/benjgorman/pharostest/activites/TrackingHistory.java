package com.benjgorman.pharostest.activites;

import com.benjgorman.pharostest.DatabaseAdapter;
import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.layout;
import com.benjgorman.pharostest.stores.OrderStore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;

public class TrackingHistory extends ListActivity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		ListAdapter adapter;
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  
		
		setContentView(R.layout.tracking_history);
        
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        Cursor orderCursor = db.getOrderCursor();

        adapter = new SimpleCursorAdapter(
                this, R.layout.rowlayout,   orderCursor,               
                new String[] { OrderStore.TRACKING_NO },         
                new int[] {R.id.trackingNo}); 
       
        setListAdapter(adapter);
    }
	
	// ListView and view (row) on which was clicked, position and
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			super.onListItemClick(l, v, position, id);
			
			Intent i = new Intent(this, TrackingResult.class);
		  	this.startActivity(i);
		    
		}
               
	}



package com.benjgorman.pharostest.tabs;

import com.benjgorman.pharostest.DatabaseAdapter;
import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.activites.TrackingResult;
import com.benjgorman.pharostest.stores.OrderStore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.app.ListActivity;

public class HistoryTab extends ListActivity{
	Context context;
	@Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		ListAdapter adapter;
		
		setContentView(R.layout.history);
        
        
        DatabaseAdapter db = new DatabaseAdapter(getApplicationContext());
        Cursor orderCursor = db.getOrderCursor();

        adapter = new SimpleCursorAdapter(
                this, R.layout.history_row,   orderCursor,               
                new String[] { OrderStore.TRACKING_NO, OrderStore.ID },         
                new int[] {R.id.trackingNo, R.id.orderNo}); 
       
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
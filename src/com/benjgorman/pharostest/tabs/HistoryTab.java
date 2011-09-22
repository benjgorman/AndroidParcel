package com.benjgorman.pharostest.tabs;

import com.benjgorman.pharostest.R;
import com.benjgorman.pharostest.R.id;
import com.benjgorman.pharostest.R.layout;
import com.benjgorman.pharostest.tablayout.ScrollableTabActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HistoryTab extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
    }
}


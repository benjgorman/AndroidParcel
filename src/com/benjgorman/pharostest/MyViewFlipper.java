package com.benjgorman.pharostest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ViewFlipper;
//this class overrides viewflipper to fix a bug with keyboard/layout switching
public class MyViewFlipper extends ViewFlipper {

    public MyViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDetachedFromWindow() {
        try{
            super.onDetachedFromWindow();
        }catch(Exception e) {
        	stopFlipping();
        }
    }


}

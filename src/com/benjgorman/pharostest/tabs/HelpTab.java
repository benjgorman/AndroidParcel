package com.benjgorman.pharostest.tabs;

import com.benjgorman.pharostest.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class HelpTab extends ListActivity implements OnClickListener
{
 public OnLongClickListener longClickListner;
 LinearLayout panel1,panel2,panel3,panel4,panel5, panel6, panel7, panel8;
 TextView text1,text2,text3,text4,text5, text6, text7, text8;
 View openLayout;
 
 @Override
 public void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.help);
  
  Button button = (Button)findViewById(R.id.btn_email);
  button.setOnClickListener(
     	new OnClickListener()
      	{
				public void onClick(View v) {
					Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

					String aEmailList[] = { "norrehlienad90@hotmail.com" };
					String aEmailCCList[] = { "" };
					String aEmailBCCList[] = { "" };

					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
					emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
					emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);

					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Additional Question");

					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");

					startActivity(emailIntent);
				}	
     	}
   );
  
  panel1 = (LinearLayout) findViewById(R.id.panel1);
  panel2 = (LinearLayout) findViewById(R.id.panel2);
  panel3 = (LinearLayout) findViewById(R.id.panel3);
  panel4 = (LinearLayout) findViewById(R.id.panel4);
  panel5 = (LinearLayout) findViewById(R.id.panel5);
  panel6 = (LinearLayout) findViewById(R.id.panel6);
  panel7 = (LinearLayout) findViewById(R.id.panel7);
  panel8 = (LinearLayout) findViewById(R.id.panel8);
  //panel1.setVisibility(View.VISIBLE);
  
  //panel1.setVisibility(View.VISIBLE);
  
  //Log.v("CZ","height at first ..." + panel1.getMeasuredHeight());
  
  text1 = (TextView) findViewById(R.id.text1);
  text2 = (TextView) findViewById(R.id.text2);
  text3 = (TextView) findViewById(R.id.text3);
  text4 = (TextView) findViewById(R.id.text4);
  text5 = (TextView) findViewById(R.id.text5);
  text6 = (TextView) findViewById(R.id.text6);
  text7 = (TextView) findViewById(R.id.text7);
  text8 = (TextView) findViewById(R.id.text8);
  
  text1.setOnClickListener(this);
  text2.setOnClickListener(this);
  text3.setOnClickListener(this);
  text4.setOnClickListener(this);
  text5.setOnClickListener(this);
  text6.setOnClickListener(this);
  text7.setOnClickListener(this);
  text8.setOnClickListener(this);
  
 }

 public void onClick(View v)
 {
  hideOthers(v);
 }
 private void hideThemAll()
 {
  if(openLayout == null) return;
  if(openLayout == panel1)
   panel1.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
  if(openLayout == panel2)
   panel2.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
  if(openLayout == panel3)
   panel3.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
  if(openLayout == panel4)
   panel4.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel4, true));
  if(openLayout == panel5)
   panel5.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel5, true));
  if(openLayout == panel6)
   panel6.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel6, true));
  if(openLayout == panel7)
	panel7.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel7, true));
  if(openLayout == panel8)
	panel8.startAnimation(new ScaleAnimToHide(1.0f, 1.0f, 1.0f, 0.0f, 500, panel8, true));
 }
 private void hideOthers(View layoutView)
 {
  {
   int v;
   if(layoutView.getId() == R.id.text1)
   {
    v = panel1.getVisibility();
    if(v != View.VISIBLE)
    {
     panel1.setVisibility(View.VISIBLE);
     Log.v("CZ","height..." + panel1.getHeight());
    }
    
    //panel1.setVisibility(View.GONE);
    //Log.v("CZ","again height..." + panel1.getHeight());
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel1.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel1, true));
    }
   }
   else if(layoutView.getId() == R.id.text2)
   {
    v = panel2.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel2.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel2, true));
    }
   }
   else if(layoutView.getId() == R.id.text3)
   {
    v = panel3.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel3.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel3, true));
    }
   }
   else if(layoutView.getId() == R.id.text4)
   {
    v = panel4.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel4.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel4, true));
    }
   }
   else if(layoutView.getId() == R.id.text5)
   {
    v = panel5.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel5.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel5, true));
    }
   }
   else if(layoutView.getId() == R.id.text6)
   {
    v = panel6.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel6.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel6, true));
    }
   }
   else if(layoutView.getId() == R.id.text7)
   {
    v = panel7.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel7.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel7, true));
    }
   }
   else if(layoutView.getId() == R.id.text8)
   {
    v = panel8.getVisibility();
    hideThemAll();
    if(v != View.VISIBLE)
    {
     panel8.startAnimation(new ScaleAnimToShow(1.0f, 1.0f, 1.0f, 0.0f, 500, panel8, true));
    }
   }
  }
 }
 
 public class ScaleAnimToHide extends ScaleAnimation
 {

         private View mView;

         private LayoutParams mLayoutParams;

         private int mMarginBottomFromY, mMarginBottomToY;

         private boolean mVanishAfter = false;

         public ScaleAnimToHide(float fromX, float toX, float fromY, float toY, int duration, View view,boolean vanishAfter)
         {
             super(fromX, toX, fromY, toY);
             setDuration(duration);
             openLayout = null;
             mView = view;
             mVanishAfter = vanishAfter;
             mLayoutParams = (LayoutParams) view.getLayoutParams();
             int height = mView.getHeight();
             mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin - height;
             mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) - height;
            
             Log.v("CZ","height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY  + " , mMarginBottomToY.." +mMarginBottomToY);
         }

         @Override
         protected void applyTransformation(float interpolatedTime, Transformation t)
         {
             super.applyTransformation(interpolatedTime, t);
             if (interpolatedTime < 1.0f)
             {
                 int newMarginBottom = mMarginBottomFromY + (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime);
                 mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin,mLayoutParams.rightMargin, newMarginBottom);
                 mView.getParent().requestLayout();
                 //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
             }
             else if (mVanishAfter)
             {
                 mView.setVisibility(View.GONE);
             }
         }
 }
 
 public class ScaleAnimToShow extends ScaleAnimation
 {

         private View mView;

         private LayoutParams mLayoutParams;

         private int mMarginBottomFromY, mMarginBottomToY;

         private boolean mVanishAfter = false;

         public ScaleAnimToShow(float toX, float fromX, float toY, float fromY, int duration, View view,boolean vanishAfter)
         {
             super(fromX, toX, fromY, toY);
             openLayout = view;
             setDuration(duration);
             mView = view;
             mVanishAfter = vanishAfter;
             mLayoutParams = (LayoutParams) view.getLayoutParams();
             mView.setVisibility(View.VISIBLE);
             int height = mView.getHeight();
             //mMarginBottomFromY = (int) (height * fromY) + mLayoutParams.bottomMargin + height;
             //mMarginBottomToY = (int) (0 - ((height * toY) + mLayoutParams.bottomMargin)) + height;
            
             mMarginBottomFromY = 0;
             mMarginBottomToY = height;
            
             Log.v("CZ",".................height..." + height + " , mMarginBottomFromY...." + mMarginBottomFromY  + " , mMarginBottomToY.." +mMarginBottomToY);
         }

         @Override
         protected void applyTransformation(float interpolatedTime, Transformation t)
         {
             super.applyTransformation(interpolatedTime, t);
             if (interpolatedTime < 1.0f)
             {
                 int newMarginBottom = (int) ((mMarginBottomToY - mMarginBottomFromY) * interpolatedTime) - mMarginBottomToY;
                 mLayoutParams.setMargins(mLayoutParams.leftMargin, mLayoutParams.topMargin,mLayoutParams.rightMargin, newMarginBottom);
                 mView.getParent().requestLayout();
                 //Log.v("CZ","newMarginBottom..." + newMarginBottom + " , mLayoutParams.topMargin..." + mLayoutParams.topMargin);
             }
         }

 }
}
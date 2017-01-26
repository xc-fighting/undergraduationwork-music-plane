package com.game.activity;

import com.game.core.GameInfo;

import com.game.view.menuview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

@SuppressLint("HandlerLeak")
public class MenuActivity extends Activity{
	
	menuview mv;
	Button backok;
	Button backcancel;
	Dialog myDialog;
	
	public Handler handler=new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			switch(msg.what)
			{
				case 0:
				{
					Intent intent=new Intent();
					intent.setClass(MenuActivity.this,MusicSelectionActivity.class);
					MenuActivity.this.startActivity(intent);
					MenuActivity.this.finish();
				}break;
				case 1:
				{
					Intent intent=new Intent();
					intent.setClass(MenuActivity.this,GradeActivity.class);
					MenuActivity.this.startActivity(intent);
					MenuActivity.this.finish();
				}break;
				case 2:
				{
					Intent intent=new Intent();
					intent.setClass(MenuActivity.this,ShopActivity.class);
					MenuActivity.this.startActivity(intent);
					MenuActivity.this.finish();
					
				}break;
				case 3:
				{
				   myDialog.show();
				}break;
			}
		}
	};
   @Override
   protected void onCreate(Bundle savedInstancestate)
   {
	   super.onCreate(savedInstancestate);
	   requestWindowFeature(Window.FEATURE_NO_TITLE); 
	   GameInfo.getScreenInfo(this);
	   mv=new menuview(this);
	   setContentView(mv);
	   myDialog=new Dialog(this,R.style.MyDialog);
	   myDialog.setContentView(R.layout.backdialog);
	   backok=(Button)myDialog.findViewById(R.id.return_ok);
	   backok.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			MenuActivity.this.finish();
			myDialog.dismiss();
		}
		   
	   });
	   backcancel=(Button)myDialog.findViewById(R.id.return_cancel);
	   backcancel.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			myDialog.dismiss();
		}
		   
	   });
   }
   
   public boolean onKeyDown(int keyCode, KeyEvent event) {
		// // TODO Auto-generated method stub
		 if (keyCode == KeyEvent.KEYCODE_BACK) 
		 {
		    myDialog.show();
		 }
		 return super.onKeyDown(keyCode, event);
		 }
   
   
}

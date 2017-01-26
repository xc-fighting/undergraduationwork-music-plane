package com.game.activity;



import com.game.core.DBAdapter;
import com.game.core.MyHandler;
import com.game.view.gameview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;



public class GameActivity extends Activity{

	gameview gv;
	public static MyHandler handler;
	String path;
	DBAdapter db;
	
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Intent intent = this.getIntent();        //获取已有的intent对象   
		Bundle bundle = intent.getExtras();    //获取intent里面的bundle对象   
		path = bundle.getString("PATH");    //获取Bundle里面的字符串 
		gameview.isGameOn=true;
		gameview.isGamePause=false;
	//	GameInfo.getScreenInfo(this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		gv=new gameview(this,path);		
		setContentView(gv);
		handler=new MyHandler(this);
		db=new DBAdapter(this);
		db.createOrOpenDatabase();
		if(db.checkItemNULL()==true)
		{
			db.initDB();
		}
		else
		{
			db.initAllItem();
		}
	//	Toast.makeText(GameActivity.this, "width"+GameInfo.SWidth, Toast.LENGTH_SHORT).show();
	}
	
	protected void onDestroy()
	{
		super.onDestroy();
		db.close_db();
	}
	
	protected void onPause()
	{
		super.onPause();
	}
	
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
		// // TODO Auto-generated method stub
		 if (keyCode == KeyEvent.KEYCODE_BACK) 
		 {
		   gameview.isGameOn = false;
		   Intent intent=new Intent();
		   intent.setClass(GameActivity.this,MenuActivity.class);
		   GameActivity.this.startActivity(intent);
		   GameActivity.this.finish();
		 }
		 return super.onKeyDown(keyCode, event);
		 }
	
}
